SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[FUN_FUNCIONARIO]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[FUN_FUNCIONARIO](
	[FUN_ID] [int] IDENTITY(1,1) NOT NULL,
	[FUN_NM] [nvarchar](4000) NOT NULL,
	[FUN_CD_MATRICULA] [varchar](20) NULL,
 CONSTRAINT [PK_dbo.FUN_FUNCIONARIO] PRIMARY KEY CLUSTERED 
(
	[FUN_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[LIV_LIVRO]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[LIV_LIVRO](
	[LIV_ID] [int] IDENTITY(1,1) NOT NULL,
	[LIV_NM_TITULO] [nvarchar](4000) NOT NULL,
	[LIV_NM_AUTOR] [varchar](60) NULL,
	[LIV_SC_AREA] [varchar](100) NULL,
	[LIV_NU_ANO] [int] NOT NULL,
	[LIV_DS_RESUMO] [varchar](2000) NULL,
	[LIV_NM_ISBN] [varchar](40) NULL,
 CONSTRAINT [PK_dbo.LIV_LIVRO] PRIMARY KEY CLUSTERED 
(
	[LIV_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALN_ALUNO]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[ALN_ALUNO](
	[ALU_ID] [int] IDENTITY(1,1) NOT NULL,
	[ALN_NM_LOGIN] [nvarchar](4000) NOT NULL,
	[ALN_NM_EMAIL] [nvarchar](4000) NOT NULL,
	[ALN_CD_MATRICULA] [nvarchar](4000) NOT NULL,
 CONSTRAINT [PK_dbo.ALN_ALUNO] PRIMARY KEY CLUSTERED 
(
	[ALU_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALG_ALUGUEL]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[ALG_ALUGUEL](
	[ALG_ID] [int] IDENTITY(1,1) NOT NULL,
	[EXP_ID] [int] NOT NULL,
	[ALN_ID] [int] NOT NULL,
	[FUN_ID] [int] NOT NULL,
	[ALG_DT] [datetime] NOT NULL,
	[ALG_DT_DEVOLUCAO] [nvarchar](4000) NOT NULL,
 CONSTRAINT [PK_dbo.ALG_ALUGUEL] PRIMARY KEY CLUSTERED 
(
	[ALG_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[LCF_LANCAMENTO_FINANCEIRO]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO](
	[LCF_ID] [int] IDENTITY(1,1) NOT NULL,
	[ALN_ID] [int] NOT NULL,
	[FUN_ID] [int] NOT NULL,
	[EXP_ID] [int] NOT NULL,
	[LCF_DT] [datetime] NOT NULL,
	[LCF_CD_TIPO] [int] NOT NULL,
	[LCF_VL] [float] NOT NULL,
 CONSTRAINT [PK_dbo.LCF_LANCAMENTO_FINANCEIRO] PRIMARY KEY CLUSTERED 
(
	[LCF_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[DEV_DEVOLUCAO]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[DEV_DEVOLUCAO](
	[DEV_ID] [int] IDENTITY(1,1) NOT NULL,
	[ALG_ID] [int] NOT NULL,
	[FUN_ID] [int] NOT NULL,
	[DEV_DT] [datetime] NOT NULL,
 CONSTRAINT [PK_dbo.DEV_DEVOLUCAO] PRIMARY KEY CLUSTERED 
(
	[DEV_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[RES_RESERVA]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[RES_RESERVA](
	[RES_ID] [int] IDENTITY(1,1) NOT NULL,
	[LIV_ID] [int] NOT NULL,
	[FUN_ID] [int] NOT NULL,
	[RES_DT] [datetime] NOT NULL,
	[ALU_ID] [int] NOT NULL,
 CONSTRAINT [PK_dbo.RES_RESERVA] PRIMARY KEY CLUSTERED 
(
	[RES_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[EXP_EXEMPLAR]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
BEGIN
CREATE TABLE [dbo].[EXP_EXEMPLAR](
	[EXP_ID] [int] IDENTITY(1,1) NOT NULL,
	[LIV_ID] [int] NOT NULL,
	[EXP_ST] [int] NULL,
 CONSTRAINT [PK_dbo.EXP_EXEMPLAR] PRIMARY KEY CLUSTERED 
(
	[EXP_ID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALN_ALUNO_ALG_ALUGUEL]') AND type = 'F')
ALTER TABLE [dbo].[ALG_ALUGUEL]  WITH CHECK ADD  CONSTRAINT [ALN_ALUNO_ALG_ALUGUEL] FOREIGN KEY([ALN_ID])
REFERENCES [dbo].[ALN_ALUNO] ([ALU_ID])
GO
ALTER TABLE [dbo].[ALG_ALUGUEL] CHECK CONSTRAINT [ALN_ALUNO_ALG_ALUGUEL]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[EXP_EXEMPLAR_ALG_ALUGUEL]') AND type = 'F')
ALTER TABLE [dbo].[ALG_ALUGUEL]  WITH CHECK ADD  CONSTRAINT [EXP_EXEMPLAR_ALG_ALUGUEL] FOREIGN KEY([EXP_ID])
REFERENCES [dbo].[EXP_EXEMPLAR] ([EXP_ID])
GO
ALTER TABLE [dbo].[ALG_ALUGUEL] CHECK CONSTRAINT [EXP_EXEMPLAR_ALG_ALUGUEL]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[FUN_FUNCIONARIO_ALG_ALUGUEL]') AND type = 'F')
ALTER TABLE [dbo].[ALG_ALUGUEL]  WITH CHECK ADD  CONSTRAINT [FUN_FUNCIONARIO_ALG_ALUGUEL] FOREIGN KEY([FUN_ID])
REFERENCES [dbo].[FUN_FUNCIONARIO] ([FUN_ID])
GO
ALTER TABLE [dbo].[ALG_ALUGUEL] CHECK CONSTRAINT [FUN_FUNCIONARIO_ALG_ALUGUEL]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALN_ALUNO_LCF_LANCAMENTO_FINANCEIRO]') AND type = 'F')
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO]  WITH CHECK ADD  CONSTRAINT [ALN_ALUNO_LCF_LANCAMENTO_FINANCEIRO] FOREIGN KEY([ALN_ID])
REFERENCES [dbo].[ALN_ALUNO] ([ALU_ID])
GO
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO] CHECK CONSTRAINT [ALN_ALUNO_LCF_LANCAMENTO_FINANCEIRO]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[EXP_EXEMPLAR_LCF_LANCAMENTO_FINANCEIRO]') AND type = 'F')
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO]  WITH CHECK ADD  CONSTRAINT [EXP_EXEMPLAR_LCF_LANCAMENTO_FINANCEIRO] FOREIGN KEY([EXP_ID])
REFERENCES [dbo].[EXP_EXEMPLAR] ([EXP_ID])
GO
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO] CHECK CONSTRAINT [EXP_EXEMPLAR_LCF_LANCAMENTO_FINANCEIRO]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[FUN_FUNCIONARIO_LCF_LANCAMENTO_FINANCEIRO]') AND type = 'F')
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO]  WITH CHECK ADD  CONSTRAINT [FUN_FUNCIONARIO_LCF_LANCAMENTO_FINANCEIRO] FOREIGN KEY([FUN_ID])
REFERENCES [dbo].[FUN_FUNCIONARIO] ([FUN_ID])
GO
ALTER TABLE [dbo].[LCF_LANCAMENTO_FINANCEIRO] CHECK CONSTRAINT [FUN_FUNCIONARIO_LCF_LANCAMENTO_FINANCEIRO]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALG_ALUGUEL_DEV_DEVOLUCAO]') AND type = 'F')
ALTER TABLE [dbo].[DEV_DEVOLUCAO]  WITH CHECK ADD  CONSTRAINT [ALG_ALUGUEL_DEV_DEVOLUCAO] FOREIGN KEY([ALG_ID])
REFERENCES [dbo].[ALG_ALUGUEL] ([ALG_ID])
GO
ALTER TABLE [dbo].[DEV_DEVOLUCAO] CHECK CONSTRAINT [ALG_ALUGUEL_DEV_DEVOLUCAO]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[FUN_FUNCIONARIO_DEV_DEVOLUCAO]') AND type = 'F')
ALTER TABLE [dbo].[DEV_DEVOLUCAO]  WITH CHECK ADD  CONSTRAINT [FUN_FUNCIONARIO_DEV_DEVOLUCAO] FOREIGN KEY([DEV_ID])
REFERENCES [dbo].[FUN_FUNCIONARIO] ([FUN_ID])
GO
ALTER TABLE [dbo].[DEV_DEVOLUCAO] CHECK CONSTRAINT [FUN_FUNCIONARIO_DEV_DEVOLUCAO]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ALN_ALUNO_RES_RESERVA]') AND type = 'F')
ALTER TABLE [dbo].[RES_RESERVA]  WITH CHECK ADD  CONSTRAINT [ALN_ALUNO_RES_RESERVA] FOREIGN KEY([ALU_ID])
REFERENCES [dbo].[ALN_ALUNO] ([ALU_ID])
GO
ALTER TABLE [dbo].[RES_RESERVA] CHECK CONSTRAINT [ALN_ALUNO_RES_RESERVA]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[FUN_FUNCIONARIO_RES_RESERVA]') AND type = 'F')
ALTER TABLE [dbo].[RES_RESERVA]  WITH CHECK ADD  CONSTRAINT [FUN_FUNCIONARIO_RES_RESERVA] FOREIGN KEY([FUN_ID])
REFERENCES [dbo].[FUN_FUNCIONARIO] ([FUN_ID])
GO
ALTER TABLE [dbo].[RES_RESERVA] CHECK CONSTRAINT [FUN_FUNCIONARIO_RES_RESERVA]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[LIV_LIVRO_RES_RESERVA]') AND type = 'F')
ALTER TABLE [dbo].[RES_RESERVA]  WITH CHECK ADD  CONSTRAINT [LIV_LIVRO_RES_RESERVA] FOREIGN KEY([LIV_ID])
REFERENCES [dbo].[LIV_LIVRO] ([LIV_ID])
GO
ALTER TABLE [dbo].[RES_RESERVA] CHECK CONSTRAINT [LIV_LIVRO_RES_RESERVA]
GO
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[LIV_LIVRO_EXP_EXEMPLAR]') AND type = 'F')
ALTER TABLE [dbo].[EXP_EXEMPLAR]  WITH CHECK ADD  CONSTRAINT [LIV_LIVRO_EXP_EXEMPLAR] FOREIGN KEY([LIV_ID])
REFERENCES [dbo].[LIV_LIVRO] ([LIV_ID])
GO
ALTER TABLE [dbo].[EXP_EXEMPLAR] CHECK CONSTRAINT [LIV_LIVRO_EXP_EXEMPLAR]
