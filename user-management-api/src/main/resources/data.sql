INSERT INTO users (id, name, email, role) VALUES (1, 'Alice Johnson', 'alice@example.com', 'ADMIN');
INSERT INTO users (id, name, email, role) VALUES (2, 'Bob Smith', 'bob@example.com', 'USER');

-- Seed employees (optional)
INSERT INTO employees (id, name, email, payroll, department, role, joining_date, contract_type) VALUES
  (1, 'Jane Cooper', 'jane.cooper@example.com', '121948ASH3', 'Finance', 'Sr. Accountant', DATE '2025-02-23', 'Full-time'),
  (2, 'Brooklyn Simmons', 'brooklyn.simmons@example.com', 'BHABHD127', 'Engineer', 'Lead. Back End Dev', DATE '2025-02-18', 'Freelance');
