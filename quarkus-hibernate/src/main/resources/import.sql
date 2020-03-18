INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<15.0s', 36);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<17.5s', 62);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<20.0s', 75);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<22.5s', 82);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<25.0s', 87);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<27.5s', 91);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<30.0s', 92);
INSERT INTO passengerstiming(id, xLabel, yValue)
VALUES (nextval('hibernate_sequence'), '<40.0s', 96);



INSERT INTO peak(id, name, dateFrom, dateTo, total)
VALUES (nextval('hibernate_sequence'), 'Peak 24 hr', '2018-12-13T10:13Z', '2018-12-14T10:07Z', 606);
INSERT INTO peak(id, name, dateFrom, dateTo, total)
VALUES (nextval('hibernate_sequence'), 'Peak 1', '2018-12-13T10:07Z', '2018-12-13T11:07Z', 214);
INSERT INTO peak(id, name, dateFrom, dateTo, total)
VALUES (nextval('hibernate_sequence'), 'Peak 30 mins', '2018-12-13T10:16Z', '2018-12-13T10:46Z', 156);
INSERT INTO peak(id, name, dateFrom, dateTo, total)
VALUES (nextval('hibernate_sequence'), 'Peak 15 mins', '2018-12-13T10:13Z', '2018-12-13T10:28Z', 91);

INSERT INTO throughput(id, noPassengers, previousPeriod)
VALUES (nextval('hibernate_sequence'), 606, 234.8);