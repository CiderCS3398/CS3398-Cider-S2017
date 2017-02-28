create table Food (
FoNo NUMBER(5)
PRIMARY KEY (FoNo)
);

create table Meats (
FoNo NUMBER(5),
TypeOf VARCHAR(25),
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);

create table Veggies (
FoNo NUMBER(5),
TypeOf VARCHAR(25),
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);

create table DrySeasonings (
FoNo NUMBER(5),
TypeOf VARCHAR(25),
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);

create table WetSeasonings (
FoNo NUMBER(5),
TypeOf VARCHAR(25),
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);

create table Recipes (
ReNo NUMBER(5),
FoNo NUMBER(5),
Amt VARCHAR(15),
Measured VARCHAR(20),
PRIMARY KEY (ReNo),
FOREIGN KEY (FoNo) REFERENCES Food(FoNo)
);