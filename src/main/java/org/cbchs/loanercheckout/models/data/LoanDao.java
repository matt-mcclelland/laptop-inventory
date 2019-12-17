package org.cbchs.loanercheckout.models.data;

import org.cbchs.loanercheckout.models.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LoanDao extends CrudRepository<Loan, Integer> {
}
