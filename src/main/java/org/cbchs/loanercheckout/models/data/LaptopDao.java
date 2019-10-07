package org.cbchs.loanercheckout.models.data;

import org.cbchs.loanercheckout.models.Laptop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface LaptopDao extends CrudRepository<Laptop, Integer> {

}
