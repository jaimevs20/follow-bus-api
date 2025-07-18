CREATE TABLE followbus.linha (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL,      -- código oficial da linha
    nome VARCHAR(100) NOT NULL,       -- nome descritivo da linha
    sentido VARCHAR(50),              -- ex: "ida", "volta"
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE followbus.parada (
    id SERIAL PRIMARY KEY,                      -- ID auto-incremental
    nome VARCHAR(100) NOT NULL,                 -- Nome da parada (ex: "Av. Paulista, 1200")
    latitude DOUBLE PRECISION NOT NULL,         -- Latitude com alta precisão (ex: -23.56123)
    longitude DOUBLE PRECISION NOT NULL,        -- Longitude com alta precisão (ex: -46.65567)
    CONSTRAINT coord_uniq UNIQUE (latitude, longitude)  -- Garante que não existam paradas duplicadas nas mesmas coordenadas
);

CREATE TABLE followbus.linha_parada (
    id SERIAL PRIMARY KEY,
    linha_id INTEGER NOT NULL REFERENCES followbus.linha(id) ON DELETE CASCADE,
    parada_id INTEGER NOT NULL REFERENCES followbus.parada(id) ON DELETE CASCADE,
    ordem INTEGER NOT NULL,
    UNIQUE (linha_id, parada_id)
);

CREATE TABLE followbus.veiculo_posicao (
    id SERIAL PRIMARY KEY,
    linha_id INTEGER REFERENCES followbus.linha(id),
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    horario TIMESTAMP NOT NULL,
    velocidade_kmh DOUBLE PRECISION,
    placa VARCHAR(10),
    numero_veiculo VARCHAR(20)
);

CREATE TABLE followbus.veiculo_historico (
    id SERIAL PRIMARY KEY,
    linha_id INTEGER REFERENCES followbus.linha(id),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    horario TIMESTAMP,
    velocidade_kmh DOUBLE PRECISION,
    numero_veiculo VARCHAR(20)
);

CREATE TABLE followbus.lotacao_estimativa (
    id SERIAL PRIMARY KEY,
    linha_id INTEGER REFERENCES followbus.linha(id),
    hora TIME NOT NULL,
    dia_semana INTEGER, -- 0=Domingo, 1=Segunda...
    estimativa_ocupacao_percentual DOUBLE PRECISION -- ex: 75.2 (%)
);



