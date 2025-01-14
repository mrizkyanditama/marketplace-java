INSERT INTO products (product_id, name, description)
VALUES 
    ('1', 'Dell Laptop', 'High-performance laptop from Dell'),
    ('2', 'Samsung Smartphone', 'Feature-rich smartphone from Samsung'),
    ('3', 'Apple iPad', 'Popular tablet from Apple'),
    ('4', 'Sony Headphones', 'Noise-cancelling headphones from Sony'),
    ('5', 'LG TV', 'Ultra HD Smart TV from LG'),
    ('6', 'HP Printer', 'Multifunction printer from HP'),
    ('7', 'Microsoft Surface', 'Versatile laptop from Microsoft'),
    ('8', 'Canon Camera', 'High-quality digital camera from Canon'),
    ('9', 'Bose Speakers', 'Premium speakers from Bose'),
    ('10', 'Xiaomi Smartwatch', 'Smartwatch with advanced features from Xiaomi'),
    ('11', 'Google Pixel Phone', 'Flagship smartphone from Google'),
    ('12', 'Lenovo ThinkPad', 'Business-oriented laptop from Lenovo'),
    ('13', 'Amazon Kindle', 'Popular e-reader from Amazon'),
    ('14', 'GoPro Action Camera', 'Compact camera for action photography from GoPro'),
    ('15', 'Nikon DSLR Camera', 'Professional-grade DSLR camera from Nikon'),
    ('16', 'Panasonic Microwave', 'Microwave oven from Panasonic'),
    ('17', 'Apple MacBook', 'Sleek and powerful laptop from Apple'),
    ('18', 'JBL Bluetooth Speaker', 'Portable Bluetooth speaker from JBL'),
    ('19', 'Samsung Smart Refrigerator', 'Smart refrigerator with advanced features from Samsung'),
    ('20', 'Philips Electric Shaver', 'High-performance electric shaver from Philips')
ON CONFLICT DO NOTHING;

INSERT INTO tags (tag_id, name)
VALUES 
    ('1', 'Electronics'),
    ('2', 'Mobile'),
    ('3', 'Gadget'),
    ('4', 'Computer'),
    ('5', 'Home Appliance'),
    ('6', 'Camera'),
    ('7', 'Laptop'),
    ('8', 'Smartphone'),
    ('9', 'Audio'),
    ('10', 'Tablet')
ON CONFLICT DO NOTHING;

INSERT INTO product_tag (product_tag_id, product_id, tag_id)
VALUES 
    ('1', '1', '1'),   -- Dell Laptop - Electronics
    ('2', '2', '8'),   -- Samsung Smartphone - Smartphone
    ('3', '3', '1'),   -- Apple iPad - Electronics
    ('4', '3', '10'),  -- Apple iPad - Tablet
    ('5', '4', '9'),   -- Sony Headphones - Audio
    ('6', '5', '5'),   -- LG TV - Home Appliance
    ('7', '6', '1'),   -- HP Printer - Electronics
    ('8', '7', '7'),   -- Microsoft Surface - Laptop
    ('9', '8', '6'),   -- Canon Camera - Camera
    ('10', '9', '9'),  -- Bose Speakers - Audio
    ('11', '10', '8'),  -- Xiaomi Smartwatch - Smartphone
    ('12', '11', '8'),  -- Google Pixel Phone - Smartphone
    ('13', '12', '7'),  -- Lenovo ThinkPad - Laptop
    ('14', '13', '1'),  -- Amazon Kindle - Electronics
    ('15', '14', '6'),  -- GoPro Action Camera - Camera
    ('16', '15', '6'),  -- Nikon DSLR Camera - Camera
    ('17', '16', '5'),  -- Panasonic Microwave - Home Appliance
    ('18', '17', '7'),  -- Apple MacBook - Laptop
    ('19', '18', '9'),  -- JBL Bluetooth Speaker - Audio
    ('20', '19', '5'),  -- Samsung Smart Refrigerator - Home Appliance
    ('21', '20', '9');  -- Philips Electric Shaver - Audio