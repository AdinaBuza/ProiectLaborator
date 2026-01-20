package org.example.parkinglot.servlets.users;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.parkinglot.common.UserDto;
import org.example.parkinglot.ejb.InvoiceBean;
import org.example.parkinglot.ejb.UsersBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_USERS"}))
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Inject
    InvoiceBean invoiceBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = usersBean.findAllUsers();
        request.setAttribute("users", users);

        // Task 2: Afișăm invoice-uri doar dacă are rolul potrivit
        if (request.isUserInRole("INVOICING")) {
            if (!invoiceBean.getUserIds().isEmpty()) {
                Collection<String> usernames = usersBean.findUsernamesByUserIds(invoiceBean.getUserIds());
                request.setAttribute("invoices", usernames);
            }
        }

        request.setAttribute("activePage", "Users");
        request.getRequestDispatcher("/WEB-INF/pages/users/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Task 2: Protejăm procesarea form-ului
        if (request.isUserInRole("INVOICING")) {
            String[] userIdsAsString = request.getParameterValues("user_ids");
            if (userIdsAsString != null) {
                List<Long> userIds = new ArrayList<>();
                for (String userIdAsString : userIdsAsString) {
                    userIds.add(Long.parseLong(userIdAsString));
                }
                invoiceBean.getUserIds().addAll(userIds);
            }
        }
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}