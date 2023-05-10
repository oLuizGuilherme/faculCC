-- Gerado pelo gerador de DDL do dbeaver CE
-- public.dim_campeos_x_partidas definition

-- Drop table

-- DROP TABLE dim_campeos_x_partidas;

CREATE TABLE dim_campeos_x_partidas (
	"index" int8 NOT NULL,
	"summonerIndex" int8 NULL,
	"teamId" int8 NULL,
	"championId" int8 NULL,
	"gameId" float8 NULL,
	CONSTRAINT dim_campeos_x_partidas_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_campeos_x_partidas_index ON public.dim_campeos_x_partidas USING btree (index);


-- public.dim_champions definition

-- Drop table

-- DROP TABLE dim_champions;

CREATE TABLE dim_champions (
	"index" int8 NOT NULL,
	nome text NULL,
	id int8 NULL,
	CONSTRAINT dim_champions_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_champions_index ON public.dim_champions USING btree (index);


-- public.dim_game_id definition

-- Drop table

-- DROP TABLE dim_game_id;

CREATE TABLE dim_game_id (
	"index" int8 NOT NULL,
	"gameId" float8 NULL,
	CONSTRAINT dim_game_id_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_game_id_index ON public.dim_game_id USING btree (index);


-- public.dim_ganhador definition

-- Drop table

-- DROP TABLE dim_ganhador;

CREATE TABLE dim_ganhador (
	"index" int8 NOT NULL,
	"gameId" float8 NULL,
	"teamId" int8 NULL,
	CONSTRAINT dim_ganhador_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_ganhador_index ON public.dim_ganhador USING btree (index);


-- public.dim_objetivos definition

-- Drop table

-- DROP TABLE dim_objetivos;

CREATE TABLE dim_objetivos (
	"index" int8 NOT NULL,
	"gameId" float8 NULL,
	"teamId" int8 NULL,
	"firstBlood" bool NULL,
	"firstTower" bool NULL,
	"firstInhibitor" bool NULL,
	"firstBaron" bool NULL,
	"firstDragon" bool NULL,
	"firstRiftHerald" bool NULL,
	"towerKills" int8 NULL,
	"inhibitorKills" int8 NULL,
	"baronKills" int8 NULL,
	"dragonKills" int8 NULL,
	CONSTRAINT dim_objetivos_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_objetivos_index ON public.dim_objetivos USING btree (index);


-- public.dim_patch_notes definition

-- Drop table

-- DROP TABLE dim_patch_notes;

CREATE TABLE dim_patch_notes (
	"index" int8 NOT NULL,
	"data" text NULL,
	CONSTRAINT dim_patch_notes_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_patch_notes_index ON public.dim_patch_notes USING btree (index);


-- public.dim_perdedor definition

-- Drop table

-- DROP TABLE dim_perdedor;

CREATE TABLE dim_perdedor (
	"index" int8 NOT NULL,
	"gameId" float8 NULL,
	"teamId" int8 NULL,
	CONSTRAINT dim_perdedor_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_perdedor_index ON public.dim_perdedor USING btree (index);


-- public.dim_team_id definition

-- Drop table

-- DROP TABLE dim_team_id;

CREATE TABLE dim_team_id (
	"index" int8 NOT NULL,
	"teamId" int8 NULL,
	team text NULL,
	CONSTRAINT dim_team_id_pk PRIMARY KEY (index)
);
CREATE INDEX ix_dim_team_id_index ON public.dim_team_id USING btree (index);


-- public.fato_partida definition

-- Drop table

-- DROP TABLE fato_partida;

CREATE TABLE fato_partida (
	id int4 NOT NULL,
	fk_dim_campeoes_x_partida int4 NULL,
	fk_dim_champions int4 NULL,
	fk_dim_game_id int4 NULL,
	fk_dim_ganhador int4 NULL,
	fk_dim_objetivos int4 NULL,
	fk_dim_patch_notes int4 NULL,
	fk_dim_perdedor int4 NULL,
	fk_dim_team_id int4 NULL,
	CONSTRAINT fato_partida_pk PRIMARY KEY (id),
	CONSTRAINT fato_partida_fk_campeoes_partida FOREIGN KEY (fk_dim_campeoes_x_partida) REFERENCES dim_campeos_x_partidas("index"),
	CONSTRAINT fato_partida_fk_champions FOREIGN KEY (fk_dim_champions) REFERENCES dim_champions("index"),
	CONSTRAINT fato_partida_fk_game_id FOREIGN KEY (fk_dim_game_id) REFERENCES dim_game_id("index"),
	CONSTRAINT fato_partida_fk_ganhador FOREIGN KEY (fk_dim_ganhador) REFERENCES dim_ganhador("index"),
	CONSTRAINT fato_partida_fk_objetivos FOREIGN KEY (fk_dim_objetivos) REFERENCES dim_objetivos("index"),
	CONSTRAINT fato_partida_fk_patch_notes FOREIGN KEY (fk_dim_patch_notes) REFERENCES dim_patch_notes("index"),
	CONSTRAINT fato_partida_fk_perdedor FOREIGN KEY (fk_dim_perdedor) REFERENCES dim_perdedor("index"),
	CONSTRAINT fato_partida_fk_team_id FOREIGN KEY (fk_dim_team_id) REFERENCES dim_team_id("index")
);