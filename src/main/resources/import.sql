-- car brands
INSERT INTO car_brands(id, name, created_at, updated_at) VALUES (1, 'Ford', current_timestamp, current_timestamp);
INSERT INTO car_brands(id, name, created_at, updated_at) VALUES (2, 'Honda', current_timestamp, current_timestamp);
INSERT INTO car_brands(id, name, created_at, updated_at) VALUES (3, 'Fiat', current_timestamp, current_timestamp);
INSERT INTO car_brands(id, name, created_at, updated_at) VALUES (4, 'Datsun', current_timestamp, current_timestamp);
INSERT INTO car_brands(id, name, created_at, updated_at) VALUES (5, 'Mercedes-Benz', current_timestamp, current_timestamp);

-- car models
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (1, 'Focus', 1, '1998-01-01', current_timestamp, current_timestamp, current_timestamp);
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (2, 'Fiesta', 1, '1976-01-01', current_timestamp, current_timestamp, current_timestamp);
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (3, 'Accord', 2, '1976-01-01', current_timestamp, current_timestamp, current_timestamp);
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (4, 'Panda', 3, '1980-01-01', current_timestamp, current_timestamp, current_timestamp);
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (5, '240z', 4, '1969-01-01', '1978-01-01', current_timestamp, current_timestamp);
INSERT INTO car_models(id, name, brand_id, start_date, end_date, created_at, updated_at) VALUES (6, 'CLS', 4, '2004-01-01', current_timestamp, current_timestamp, current_timestamp);

-- car parts
-- -- ford focus
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (1, 'Klocki hamulcowe - komplet ASHIKA 51-00-005', 'Dodatkowe informacje o Klocki hamulcowe - komplet 51-00-005 ASHIKA dla Ford FOCUS II Sedan (DB_, FCH, DH) (od 2005.04) 1.4. Lokalizacja w aucie: Oś tylna. Typ układu hamulcowego: Hamulce tarczowe. Długość [mm]: 123. Wysokość [mm]: 52. Grubość [mm]: 16,5. Oznaczenie kontrolne: ECE R90 APPROVED. Numer WVA: 23482. Numer WVA: 24137', 41.00, TRUE, 7, 1, current_timestamp, current_timestamp);

-- -- ford fiesta
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (2, 'Klocki hamulcowe - komplet MAXGEAR 19-2164', 'Dodatkowe informacje o Klocki hamulcowe - komplet 19-2164 MAXGEAR dla Ford FIESTA V (JH_, JD_) (2001.11 - 2010.03) 1.25 16V. Lokalizacja w aucie: Oś przednia. System hamulcowy: AKEBONO. Szerokość zewnętrzna [mm]: 103,5. Wysokość 1 [mm]: 43,8. Grubość [mm]: 15,3. Numer WVA: 21500. Styk ostrzegawczy o zużyciu: Ze stykiem zużycia. Ilość wskaźników zużycia okładzin [na oż]: 2. Ciężar [kg]: 0,94', 50.00, TRUE, 7, 2, current_timestamp, current_timestamp);

-- -- honda accord
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (3, 'Klocki hamulcowe - komplet JAPANPARTS PP-410AF', 'Dodatkowe informacje o Klocki hamulcowe - komplet PP-410AF JAPANPARTS dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3). Lokalizacja w aucie: Oś tylna. Typ układu hamulcowego: Hamulce tarczowe. Długość [mm]: 93,5. Wysokość [mm]: 47. Grubość [mm]: 15. Numer WVA: 24435. Oznaczenie kontrolne: ECE R90 APPROVED', 39.00, TRUE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (4, 'Łożysko oporowe JAPANPARTS CF-401', 'Dodatkowe informacje o Łożysko oporowe CF-401 JAPANPARTS dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3 Średnica wewnętrzna [mm]: 3 Średnica zewnętrzna [mm]: 6 Wysokość [mm]: 2 Długość [mm]: 75', 127.00, TRUE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (5, 'Wahacz zawieszenia koła DELPHI TC3633', 'Dodatkowe informacje o Wahacz zawieszenia koła TC3633 DELPHI dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3 Długość całkowita [mm]: 27 Szerokość [mm]: 8 Wysokość [mm]: 29 Długość [mm]: 20 Rodzaj wahacza: Wahacz poprzeczny', 146.00, TRUE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (6, 'Łącznik stabilizatora MASTER-SPORT 35415-PCS-MS', 'Dodatkowe informacje o Łącznik stabilizatora 35415-PCS-MS MASTER-SPORT dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3 Lokalizacja w aucie: Oś przednia, z lewej stron Pręt/Rozpórka: Drążek wahadłowy', 29.00, TRUE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (7, 'Łożysko koła DENCKERMANN W413515', 'Dodatkowe informacje o Łożysko koła W413515 DENCKERMANN dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3 Masa [g]: 116 Lokalizacja w aucie: Oś przednia', 130.00, TRUE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (8, 'Tuleja dystansowa łożyska piasty koła TEDGUM TED27429', 'Dodatkowe informacje o Tuleja dystansowa łożyska piasty koła TED27429 TEDGUM dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3)', 70.00, FALSE, 7, 3, current_timestamp, current_timestamp);
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (9, 'Uszczelka głowicy silnika AJUSA 10193900', 'Dodatkowe informacje o Uszczelka głowicy silnika 10193900 AJUSA dla Honda ACCORD VIII (CU) (od 2008.04) 2.2 i-DTEC (CU3) Grubość [mm]: 1,15 Szerokość [mm]: 193 Długość [mm]: 430 Specyfikacja: Notches A Średnica [mm]: 86 Tylko w połączeniu z: 81039500', 230.00, TRUE, 7, 3, current_timestamp, current_timestamp);

-- -- fiat panda
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (10, 'Uszczelka głowicy silnika AJUSA 10204900', 'Dodatkowe informacje o Uszczelka głowicy silnika 10204900 AJUSA dla Fiat PANDA (312_, 319_) (od 2012.02) 0.9 Średnica [mm]: 82,5 Grubość [mm]: 0,65 Szerokość [mm]: 200 Długość [mm]: 200', 108.00, TRUE, 7, 4, current_timestamp, current_timestamp);

-- -- datsun 240z
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (11, 'Drewniana kierownica Nardi Torino 365mm JDM', 'Ponadczasowa włoska drewniana kierownica sygnowana imieniem Enrico Nardi, czyli Nardi Torino w wyjątkowej specyfikacji ciemniejszego drewna, polerowanym środkiem i średnicy obręczy wynoszącej 365mm.', 1270.00, FALSE, 7, 5, current_timestamp, current_timestamp);

-- -- mercedes-benz cls
INSERT INTO car_parts(id, name, description, price, available, delivery_time, model_id, created_at, updated_at) VALUES (12, 'Uszczelka głowicy silnika ELRING 732.640', 'Dodatkowe informacje o Uszczelka głowicy silnika 732.640 ELRING dla Mercedes-benz CLS (C218) (od 2010.10) CLS 250 CDI / BlueTEC / d (218.303, 218.304) Grubożć zabudowy [mm]: 1,35 Średnica [mm]: 84 Rodzaj uszczelnienia: Uszczelka z warstwą metalową Dodatkowo potrzebny artykuł (numer artykułu): ZKS: 584.500', 177.00, TRUE, 7, 6, current_timestamp, current_timestamp);

-- part_selling_points
INSERT INTO part_selling_points(id, title, description, part_id, created_at, updated_at) VALUES (1, 'Super uszczelka głowicy silnika', 'Najlepsza uszczelka głowicy silnika jaką posiadałam. Polecam Magda Gessler.', 10, current_timestamp, current_timestamp);

-- part_service_actions
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (1, 'Wymiana uszczelki pod głowicą #1', 'Super sprawna wymiana uszczelki pod głowicą #1.', '2020-01-01 12:30:00', '2020-01-01 13:00:00', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (2, 'Wymiana uszczelki pod głowicą #2', 'Super sprawna wymiana uszczelki pod głowicą #2.', '2020-03-23 10:23:47', '2020-03-23 11:00:00', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (3, 'Wymiana uszczelki pod głowicą #3', 'Super sprawna wymiana uszczelki pod głowicą #3.', '2020-05-03 9:48:19', '2020-05-03 10:11:11', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (4, 'Wymiana klocków hamulcowych', 'Super sprawna wymiana klocków hamulcowych.', '2020-01-13 13:13:00', '2020-01-13 14:00:00', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (5, 'Wymiana łożyska', 'Super sprawna wymiana łożyska.', '2020-02-27 12:30:00', '2020-02-27 15:14:18', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (6, 'Wymiana tulei dystansowej', 'Super sprawna wymiana tulei dystansowej.', '2020-02-27 15:30:00', '2020-02-27 16:30:00', 10, current_timestamp, current_timestamp);
INSERT INTO part_service_actions(id, title, description, start_date, end_date, part_id, created_at, updated_at) VALUES (7, 'Wymiana łącznika stabilizatora', 'Super sprawna wymiana łącznika stabilizatora.', '2020-02-28 12:30:00', '2020-02-28 13:00:00', 10, current_timestamp, current_timestamp);

CREATE SEQUENCE IF NOT EXISTS car_brands_id_seq;
CREATE SEQUENCE IF NOT EXISTS car_models_id_seq;
CREATE SEQUENCE IF NOT EXISTS car_parts_id_seq;
CREATE SEQUENCE IF NOT EXISTS part_selling_points_id_seq;
CREATE SEQUENCE IF NOT EXISTS part_service_actions_id_seq;

ALTER SEQUENCE car_brands_id_seq RESTART WITH 6;
ALTER SEQUENCE car_models_id_seq RESTART WITH 7;
ALTER SEQUENCE car_parts_id_seq RESTART WITH 13;
ALTER SEQUENCE part_selling_points_id_seq RESTART WITH 2;
ALTER SEQUENCE part_service_actions_id_seq RESTART WITH 8;