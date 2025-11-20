-- USUÁRIOS (sem IDs para evitar conflito com @GeneratedValue)
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
                                                                                    ('Ana Souza', 'ana.souza@example.com', 'Administração', 'Em transição', '2025-01-10'),
                                                                                    ('Carlos Lima', 'carlos.lima@example.com', 'TI', 'Junior', '2025-04-02');

-- TRILHAS (sem IDs para evitar conflito com @GeneratedValue)
INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
                                                                                ('Tech Skills', 'Trilha focada em habilidades técnicas para desenvolvedores', 'INTERMEDIARIO', 40, 'Programação'),
                                                                                ('Soft Skills', 'Trilha para desenvolver habilidades interpessoais', 'INICIANTE', 20, 'Comunicação');
