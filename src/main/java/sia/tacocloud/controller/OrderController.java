package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.config.OrderProps;
import sia.tacocloud.domain.Order;
import sia.tacocloud.domain.User;
import sia.tacocloud.repo.OrderRepo;

import javax.validation.Valid;

/**
 * @author Orlov Diga
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderProps props;
    private final OrderRepo orderRepo;

    public OrderController(OrderProps props, OrderRepo orderRepo) {
        this.props = props;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order,
                               Errors errors,
                               SessionStatus status,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);

        order.setUser(user);
        orderRepo.save(order);
        status.setComplete();

        log.info("Session status: {}. Order had user with full name: {}", status.isComplete(), user.getFullname());

        return "redirect:/";
    }

    @GetMapping
    public String orderForUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());

        model.addAttribute("orders", orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}
