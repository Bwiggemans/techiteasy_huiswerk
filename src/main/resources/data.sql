INSERT INTO televisions (brand, name, type, price, size, refresh_rate, screen_type, screen_quality, smart_tv,
voice_control, hdr, bluetooth, ambilight, original_stock, sold, wifi)
VALUES
('Samsung', 'LCD-QLED', '50Hz', 995.95, 15.95, 15999, 'QLED', 'HDR', true, false, true, true, true, 20889, 60299, true),
('Sony', 'QLED', '50Hz', 1095.95, 15.95, 21599, 'LCD', 'HDR', true, false, false, true, false, 60889, 91299, false),
('Panasonic', 'LCD-QLED', '50Hz', 675.95, 15.95, 14123, 'QLED', 'HDR', true, false, true, true, true, 40154, 31856, true),
('Philips', 'LCD-QLED', '50Hz', 875.95, 15.95, 89123, 'QLED', 'HDR', true, false, true, true, true, 77854, 51245, true),
('LG', 'LCD-QLED', '50Hz', 895.95, 15.95, 14123, 'QLED', 'HDR', true, false, true, true, true, 99887, 54269, true),
('Salora', 'LCD-QLED', '50Hz', 1295.95, 15.95, 14123, 'QLED', 'HDR', true, false, true, true, true, 36474, 25876, false),
('Loewe', 'Bild', '50Hz', 695.95, 15.95, 14123, 'QLED', 'HDR', true, false, false, true, false, 45217, 11254, false);

INSERT INTO cimodules (name, type, price)
VALUES
('Smit', 'Carry-in', 59.95),
('Quantis', 'Carry-in', 79.95),
('TiVuSat-HD', 'Carry-in', 49.95),
('Delta', 'Carry-in', 99.95),
('Ziggo', 'Carry-in', 109.95);

INSERT INTO remotecontrollers (compatible_with, battery_type, name, brand, price, original_stock)
VALUES
('NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 15.95, 741658),
('43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 11.95, 415235),
('OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 13.75, 112457);

INSERT INTO wallbrackets (size, ajustable, name, price)
VALUES
('25X32', false, 'LG bracket', 45.75),
('25X32/32X40', true, 'LG bracket', 37.95),
('25X25', false, 'Philips bracket', 38.85),
('25X32/32X40', true, 'Nikkei bracket', 37.95),
('25X32', false, 'Nikkei bracket', 44.75);

