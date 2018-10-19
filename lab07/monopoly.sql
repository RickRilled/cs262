--
-- This SQL script builds a monopoly database, deleting any pre-existing version.
--
-- @author kvlinden
-- @version Summer, 2015
--

-- Drop previous versions of the tables if they they exist, in reverse order of foreign keys.
DROP TABLE IF EXISTS PlayerGame;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Proporties;
DROP TABLE IF EXISTS Building;
DROP TABLE IF EXISTS GamePieces;
DROP TABLE IF EXISTS Save;

-- Create the schema.
CREATE TABLE Game (
	ID integer PRIMARY KEY, 
	time timestamp,
	finished boolean
	);

CREATE TABLE Player (
	ID integer PRIMARY KEY, 
	emailAddress varchar(50) NOT NULL,
	name varchar(50)
	);

CREATE TABLE PlayerGame (
	gameID integer REFERENCES Game(ID), 
	playerID integer REFERENCES Player(ID),
	score integer,
	location integer,
	cash integer
	);

CREATE TABLE Proporties(
	ID integer PRIMARY KEY,
	owner integer REFERENCES Player(ID),
	rent integer,
	name varchar(50)
);

CREATE TABLE Building(
	ID integer PRIMARY KEY,
	location integer REFERENCES Proporties(ID)
);

CREATE TABLE GamePieces(
	ID integer PRIMARY KEY,
	location integer REFERENCES Building(ID)
);

CREATE TABLE Save(
	playerID integer REFERENCES PlayerGame(ID),
	gameID integer REFERENCES Game(ID),
	gamePiece integer REFERENCES GamePieces(ID)
);

-- Allow users to select data from the tables.
GRANT SELECT ON Game TO PUBLIC;
GRANT SELECT ON Player TO PUBLIC;
GRANT SELECT ON PlayerGame TO PUBLIC;
GRANT SELECT ON Proporties to PUBLIC;
GRANT SELECT ON Building to PUBLIC;
GRANT SELECT ON GamePieces to PUBLIC;
GRANT SELECT ON Save to PUBLIC;

-- Add sample records.
INSERT INTO Game VALUES (1, '2006-06-27 08:00:00', TRUE);
INSERT INTO Game VALUES (2, '2006-06-28 13:20:00', FALSE);
INSERT INTO Game VALUES (3, '2006-06-29 18:41:00', FALSE);

INSERT INTO Player(ID, emailAddress) VALUES (1, 'me@calvin.edu');
INSERT INTO Player VALUES (2, 'king@gmail.edu', 'The King');
INSERT INTO Player VALUES (3, 'dog@gmail.edu', 'Dogbreath');

INSERT INTO PlayerGame VALUES (1, 1, 0.00, 0, 0);
INSERT INTO PlayerGame VALUES (1, 2, 0.00, 0, 0);
INSERT INTO PlayerGame VALUES (1, 3, 2350.00, 12, 2000);

INSERT INTO Proporties VALUES(12, 1, 250, 'Mediteranian Ave'); 

INSERT INTO Building VALUES(0, 12);

INSERT INTO GamePieces VALUES(0, 0);

INSERT INTO Save VALUES(1, 1, 0);

INSERT INTO PlayerGame VALUES (2, 1, 1000.00);
INSERT INTO PlayerGame VALUES (2, 2, 0.00);
INSERT INTO PlayerGame VALUES (2, 3, 500.00);
INSERT INTO PlayerGame VALUES (3, 2, 0.00);
INSERT INTO PlayerGame VALUES (3, 3, 5500.00);


