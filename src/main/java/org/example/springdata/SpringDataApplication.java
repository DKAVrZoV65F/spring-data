package org.example.springdata;

import org.example.springdata.entity.Account;
import org.example.springdata.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        /*jdbcTemplate.execute("INSERT INTO Account (id, name, email, bill) VALUES (1, 'Lori', 'lori@mail.com', 2000)");

        Account accountById = findAccountById(1L);
        System.out.println(accountById);*/
        for (int i = 0; i < 10; i++) {
            accountRepository.save(new Account(null, "Lori" + i, "lori" + i + "@mail.com",
                    i * 1000));
        }

        System.out.println(accountRepository.findAccountByName("Lori1"));
        accountRepository.setNameFor(6L, "Baxter");
        System.out.println(accountRepository.findAccountByName("Baxter"));
        System.out.println(accountRepository.findAccountBy("Lori5", 5000));
    }

    private Account findAccountById(Long id) {
        String sql = "SELECT * FROM Account WHERE id = %s";
        Map<String, Object> resultSet =  jdbcTemplate.queryForMap(String.format(sql, id));
        Account account = new Account();
        account.setId(id);
        account.setName((String) resultSet.get("name"));
        account.setEmail((String) resultSet.get("email"));
        account.setBill((Integer) resultSet.get("bill"));
        return account;
    }
}
