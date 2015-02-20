DROP TABLE IF EXISTS results, voters, candidates, zip_codes, elections; 

-- elections
CREATE TABLE elections(
id SERIAL NOT NULL PRIMARY KEY,
election_date DATE NOT NULL,
type VARCHAR(255) NOT NULL
);
-- zip_codes
CREATE TABLE zip_codes(
id SERIAL,
zip_code VARCHAR(6) NOT NULL UNIQUE,
PRIMARY KEY (id)
);
-- candidates
CREATE TABLE candidates(
id SERIAL,
firstname TEXT NOT NULL,
surname TEXT NOT NULL,
zip_codes_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(zip_codes_id) REFERENCES zip_codes(id)
);
-- voters
CREATE TABLE voters(
id SERIAL,
pesel VARCHAR(11) NOT NULL UNIQUE,
zip_codes_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (zip_codes_id) REFERENCES zip_codes(id)
);
-- results
CREATE TABLE results(
id SERIAL,
elections_id int REFERENCES elections(id),
voters_id int REFERENCES voters(id),
candidates_id int REFERENCES candidates(id),
UNIQUE(elections_id, voters_id),
PRIMARY KEY (id)
);

-- initial data

INSERT INTO zip_codes
 (zip_code) 
VALUES 
  ('52-320'),
  ('50-555'),
  ('52-117'),
  ('54-404'),
  ('58-316'),
  ('14-216'),
  ('03-015'),
  ('22-654'),
  ('34-934'),
  ('aa-bbb');