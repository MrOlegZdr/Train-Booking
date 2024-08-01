-- Drop user first if they exist
DROP USER if exists 'train_booking'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'train_booking'@'localhost' IDENTIFIED BY 'tr@in_b00king';

GRANT ALL PRIVILEGES ON * . * TO 'train_booking'@'localhost';