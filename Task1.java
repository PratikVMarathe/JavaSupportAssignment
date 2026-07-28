import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize the result list to avoid NullPointerException when adding overdue accounts.
        List<LoanAccount> result = new ArrayList<>();

        for (LoanAccount account : accounts) {

            // FIX: Check for null dueDate because restructured accounts may not have a due date.
            if (account.getDueDate() != null && account.getDueDate().before(new Date())) {

                // FIX: Include only accounts with an outstanding balance greater than zero.
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
