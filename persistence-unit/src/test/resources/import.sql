INSERT INTO PUBLIC.LEAGUE(ID, NAME) VALUES ('LFP', 'La Ligua'), ('PL', 'Premier League'), ('AFA', 'Fútbol Argentino');
INSERT INTO PUBLIC.CLUB(LEAGUE_ID, ID, NAME) VALUES('LFP', 'RM', 'Real Madrid'), ('LFP', 'FCB', 'Futbol Club Barcelona'), ('PL', 'CH', 'Chelsea'),('PL', 'LIV', 'Liverpool'),('AFA', 'CARP', 'Club Atletico River Plate'),('AFA', 'CABJ', 'Club Atletico Boca Juniors');
INSERT INTO PUBLIC.PLAYER(ID, NAME,CLUB_ID) VALUES('10','Lionel Messi', 'FCB');
INSERT INTO PUBLIC.PLAYER(ID, NAME,CLUB_ID) VALUES('7','Cristiano Ronaldo', 'RM');
INSERT INTO PUBLIC.PLAYER(ID, NAME,CLUB_ID) VALUES('11','Javier Saviola', 'CARP');
INSERT INTO PUBLIC.PLAYER(ID, NAME,CLUB_ID) VALUES('7','Carlos Tevez', 'CABJ');
