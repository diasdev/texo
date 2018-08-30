INSERT INTO state (uf_code, name) VALUES ('PR', 'Paraná');
INSERT INTO state (uf_code, name) VALUES ('SC', 'Santa Catarina');
INSERT INTO state (uf_code, name) VALUES ('RS', 'Rio Grande do Sul');

INSERT INTO city (id, name, capital, uf_code) VALUES (1, 'Curitiba', true, 'PR');
INSERT INTO city (id, name, capital, uf_code) VALUES (2, 'Londrina', false, 'PR');
INSERT INTO city (id, name, capital, uf_code) VALUES (3, 'Maringá', false, 'PR');
INSERT INTO city (id, name, capital, uf_code) VALUES (4, 'Joinville', false, 'SC');
INSERT INTO city (id, name, capital, uf_code) VALUES (5, 'Blumenau', false, 'SC');
INSERT INTO city (id, name, capital, uf_code) VALUES (6, 'Florianópolis', true, 'SC');
INSERT INTO city (id, name, capital, uf_code) VALUES (7, 'Porto Alegre', true, 'RS');
INSERT INTO city (id, name, capital, uf_code) VALUES (8, 'Passo Fundo', false, 'RS');
INSERT INTO city (id, name, capital, uf_code) VALUES (9, 'Pelotas', false, 'RS');