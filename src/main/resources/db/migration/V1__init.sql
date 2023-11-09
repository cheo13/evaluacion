CREATE TABLE IF NOT EXISTS conference (
    idc SERIAL,
    titconference VARCHAR(25) NOT NULL,
    desconference VARCHAR(60) NOT NULL,
    citconference VARCHAR(25) NOT NULL,
    totassconference VARCHAR(50) NOT NULL,
    PRIMARY KEY (idc)
    );

CREATE TABLE IF NOT EXISTS assistan (
    ida SERIAL,
    nameassistant VARCHAR(100) NOT NULL,
    roleassistant VARCHAR(25) NOT NULL,
    ageassistant  INTEGER NOT NULL,
    confassistant SERIAL,
    PRIMARY KEY (ida),
    FOREIGN KEY (confassistant) REFERENCES conference(idc)
    );
