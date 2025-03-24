 INSERT INTO brand (brand_id, name) values (NEXT VALUE FOR BRAND_SEQUENCE, 'Zara');
 INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES
 (NEXT VALUE FOR PRICE_SEQUENCE, (select brand_id from brand where name='Zara'), '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR'),
 (NEXT VALUE FOR PRICE_SEQUENCE, (select brand_id from brand where name='Zara'), '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR'),
 (NEXT VALUE FOR PRICE_SEQUENCE, (select brand_id from brand where name='Zara'), '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR'),
 (NEXT VALUE FOR PRICE_SEQUENCE, (select brand_id from brand where name='Zara'), '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');
