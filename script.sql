USE [master]
GO
/****** Object:  Database [App_Mi_Tienda]    Script Date: 16/11/2023 7:38:21 a. m. ******/
CREATE DATABASE [App_Mi_Tienda]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'App_Mi_Tienda', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\App_Mi_Tienda.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'App_Mi_Tienda_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\App_Mi_Tienda_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [App_Mi_Tienda] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [App_Mi_Tienda].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [App_Mi_Tienda] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET ARITHABORT OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [App_Mi_Tienda] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [App_Mi_Tienda] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET  DISABLE_BROKER 
GO
ALTER DATABASE [App_Mi_Tienda] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [App_Mi_Tienda] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [App_Mi_Tienda] SET  MULTI_USER 
GO
ALTER DATABASE [App_Mi_Tienda] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [App_Mi_Tienda] SET DB_CHAINING OFF 
GO
ALTER DATABASE [App_Mi_Tienda] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [App_Mi_Tienda] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [App_Mi_Tienda] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [App_Mi_Tienda] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [App_Mi_Tienda] SET QUERY_STORE = ON
GO
ALTER DATABASE [App_Mi_Tienda] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [App_Mi_Tienda]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](32) NOT NULL,
 CONSTRAINT [PK_categoria] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[grupo]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[grupo](
	[idMesa] [int] NOT NULL,
	[horaLlegada] [datetimeoffset](7) NOT NULL,
	[horaSalida] [datetimeoffset](7) NULL,
	[idGrupo] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK__grupo] PRIMARY KEY CLUSTERED 
(
	[idGrupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mesa]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mesa](
	[idTienda] [int] NOT NULL,
	[idMesa] [int] NOT NULL,
	[numeroMesa] [int] NOT NULL,
 CONSTRAINT [PK_mesa] PRIMARY KEY CLUSTERED 
(
	[idMesa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pedido]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pedido](
	[idPedido] [int] IDENTITY(1,1) NOT NULL,
	[idPersona_Grupo] [int] NOT NULL,
	[fechaPedido] [datetimeoffset](7) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_pedido] PRIMARY KEY CLUSTERED 
(
	[idPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pedido_producto]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pedido_producto](
	[idPedido] [int] NOT NULL,
	[idProducto] [int] NOT NULL,
	[precioFacturado] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[idPedido_Producto] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPedido_Producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[persona]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persona](
	[idDNIPersona] [varchar](10) NOT NULL,
	[nombre] [varchar](32) NOT NULL,
	[apellido] [varchar](32) NOT NULL,
	[idTipoDNI] [varchar](10) NOT NULL,
 CONSTRAINT [PK_persona] PRIMARY KEY CLUSTERED 
(
	[idDNIPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[persona_grupo]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persona_grupo](
	[idGrupo] [int] NOT NULL,
	[idPersona] [varchar](10) NOT NULL,
	[horaLlegada] [datetimeoffset](7) NULL,
	[idGrupoPersona] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idGrupoPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[producto]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producto](
	[idProducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](32) NOT NULL,
	[precioActual] [int] NOT NULL,
	[unidadesDisponibles] [int] NOT NULL,
	[idCategoria] [int] NOT NULL,
 CONSTRAINT [PK_producto] PRIMARY KEY CLUSTERED 
(
	[idProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tienda]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tienda](
	[idTiendaNit] [int] NOT NULL,
	[nombre] [varchar](32) NOT NULL,
	[direccion] [varchar](32) NOT NULL,
 CONSTRAINT [PK_tienda] PRIMARY KEY CLUSTERED 
(
	[idTiendaNit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipo_DNI]    Script Date: 16/11/2023 7:38:22 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipo_DNI](
	[idTipoDNI] [varchar](10) NOT NULL,
	[tipoDNI] [varchar](32) NULL,
 CONSTRAINT [PK_tipo_DNI] PRIMARY KEY CLUSTERED 
(
	[idTipoDNI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categoria] ON 

INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (1, N'licores')
INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (2, N'snacks')
INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (3, N'refrigerados')
INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (5, N'bebidas')
INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (6, N'panaderia')
INSERT [dbo].[categoria] ([idCategoria], [nombre]) VALUES (7, N'dulces2')
SET IDENTITY_INSERT [dbo].[categoria] OFF
GO
SET IDENTITY_INSERT [dbo].[grupo] ON 

INSERT [dbo].[grupo] ([idMesa], [horaLlegada], [horaSalida], [idGrupo]) VALUES (1, CAST(N'2023-11-05T18:05:10.8132968-05:00' AS DateTimeOffset), NULL, 1)
INSERT [dbo].[grupo] ([idMesa], [horaLlegada], [horaSalida], [idGrupo]) VALUES (2, CAST(N'2023-11-05T18:05:22.1704103-05:00' AS DateTimeOffset), NULL, 2)
INSERT [dbo].[grupo] ([idMesa], [horaLlegada], [horaSalida], [idGrupo]) VALUES (3, CAST(N'2023-11-13T08:42:25.2095900-05:00' AS DateTimeOffset), CAST(N'2023-11-16T07:10:41.2072485-05:00' AS DateTimeOffset), 1005)
INSERT [dbo].[grupo] ([idMesa], [horaLlegada], [horaSalida], [idGrupo]) VALUES (3, CAST(N'2023-11-16T07:10:48.4893078-05:00' AS DateTimeOffset), NULL, 2005)
SET IDENTITY_INSERT [dbo].[grupo] OFF
GO
INSERT [dbo].[mesa] ([idTienda], [idMesa], [numeroMesa]) VALUES (1, 1, 1)
INSERT [dbo].[mesa] ([idTienda], [idMesa], [numeroMesa]) VALUES (1, 2, 2)
INSERT [dbo].[mesa] ([idTienda], [idMesa], [numeroMesa]) VALUES (1, 3, 3)
INSERT [dbo].[mesa] ([idTienda], [idMesa], [numeroMesa]) VALUES (1, 4, 4)
GO
SET IDENTITY_INSERT [dbo].[pedido] ON 

INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (1, 1, CAST(N'2023-11-06T07:13:25.0127332-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (2, 1, CAST(N'2023-11-06T17:10:53.1884435-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (1002, 1007, CAST(N'2023-11-13T19:45:10.6172632-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (1003, 2, CAST(N'2023-11-13T20:19:56.7006570-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (1004, 1007, CAST(N'2023-11-13T21:03:43.6364261-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (2002, 2, CAST(N'2023-11-16T07:08:33.2950100-05:00' AS DateTimeOffset), 0)
INSERT [dbo].[pedido] ([idPedido], [idPersona_Grupo], [fechaPedido], [estado]) VALUES (2003, 2003, CAST(N'2023-11-16T07:11:26.8826492-05:00' AS DateTimeOffset), 0)
SET IDENTITY_INSERT [dbo].[pedido] OFF
GO
SET IDENTITY_INSERT [dbo].[pedido_producto] ON 

INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1, 3, 6500, 2, 1)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1, 1, 2800, 1, 2)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (2, 5, 2500, 2, 3)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (2, 1, 3800, 2, 4)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (2, 3, 6500, 1, 5)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1003, 3, 6500, 5, 1003)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1002, 2, 18000, 3, 1004)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1002, 3, 6500, 1, 1005)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1002, 1, 3800, 2, 1006)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1003, 2, 18000, 2, 2003)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (1003, 1, 3800, 4, 2004)
INSERT [dbo].[pedido_producto] ([idPedido], [idProducto], [precioFacturado], [cantidad], [idPedido_Producto]) VALUES (2003, 1, 3800, 2, 2005)
SET IDENTITY_INSERT [dbo].[pedido_producto] OFF
GO
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'1019845417', N'Ian', N'Sanchez M', N'CC')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'1030576147', N'Felipe', N'Castellanos', N'CC')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'1031178379', N'Michael', N'Criollo', N'CC')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'3157894512', N'Carlos', N'Castellanos', N'Otros')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'3227095002', N'Ian', N'Sanchez', N'Otros')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'79161548', N'Carlos', N'Valderrama', N'CC')
INSERT [dbo].[persona] ([idDNIPersona], [nombre], [apellido], [idTipoDNI]) VALUES (N'79464154', N'Carlos', N'Galan', N'CC')
GO
SET IDENTITY_INSERT [dbo].[persona_grupo] ON 

INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (1, N'1030576147', CAST(N'2023-11-05T18:50:06.9159233-05:00' AS DateTimeOffset), 1)
INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (2, N'3227095002', CAST(N'2023-11-07T12:01:59.1066427-05:00' AS DateTimeOffset), 2)
INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (1, N'3157894512', CAST(N'2023-11-12T14:31:52.1923086-05:00' AS DateTimeOffset), 1002)
INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (1005, N'79161548', CAST(N'2023-11-13T10:09:41.7804669-05:00' AS DateTimeOffset), 1007)
INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (2005, N'1030576147', CAST(N'2023-11-16T07:11:08.1873119-05:00' AS DateTimeOffset), 2003)
INSERT [dbo].[persona_grupo] ([idGrupo], [idPersona], [horaLlegada], [idGrupoPersona]) VALUES (1, N'1019845417', CAST(N'2023-11-16T07:27:51.1503973-05:00' AS DateTimeOffset), 2004)
SET IDENTITY_INSERT [dbo].[persona_grupo] OFF
GO
SET IDENTITY_INSERT [dbo].[producto] ON 

INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (1, N'Coca-Cola 600ml', 3800, 24, 5)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (2, N'Aguardiente Nectar Verde 375ml', 18000, 0, 1)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (3, N'redbull', 6500, 3, 3)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (5, N'empanada pollo', 2500, 10, 6)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (6, N'Antioqueño sin azucar 375ml', 19000, 10, 1)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (7, N'Zenu Salchichon Cervero unidad', 3300, 7, 3)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (8, N'Manimoto pequeño 100gr', 2100, 9, 2)
INSERT [dbo].[producto] ([idProducto], [nombre], [precioActual], [unidadesDisponibles], [idCategoria]) VALUES (1007, N'Ducales', 1200, 10, 2)
SET IDENTITY_INSERT [dbo].[producto] OFF
GO
INSERT [dbo].[tienda] ([idTiendaNit], [nombre], [direccion]) VALUES (1, N'Kanpai', N' cra 74b # 51a-43')
GO
INSERT [dbo].[tipo_DNI] ([idTipoDNI], [tipoDNI]) VALUES (N'CC', N'Cedula Ciudadania')
INSERT [dbo].[tipo_DNI] ([idTipoDNI], [tipoDNI]) VALUES (N'CE', N'Cedula Extranjeria')
INSERT [dbo].[tipo_DNI] ([idTipoDNI], [tipoDNI]) VALUES (N'Otros', N'Otros varios')
INSERT [dbo].[tipo_DNI] ([idTipoDNI], [tipoDNI]) VALUES (N'PA', N'Pasaporte')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_categoria_nombre_unique]    Script Date: 16/11/2023 7:38:23 a. m. ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_categoria_nombre_unique] ON [dbo].[categoria]
(
	[idCategoria] ASC,
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[producto] ADD  CONSTRAINT [DF_producto_unidadesDisponibles]  DEFAULT ((0)) FOR [unidadesDisponibles]
GO
ALTER TABLE [dbo].[grupo]  WITH CHECK ADD  CONSTRAINT [FK_grupo_mesa] FOREIGN KEY([idMesa])
REFERENCES [dbo].[mesa] ([idMesa])
GO
ALTER TABLE [dbo].[grupo] CHECK CONSTRAINT [FK_grupo_mesa]
GO
ALTER TABLE [dbo].[mesa]  WITH CHECK ADD  CONSTRAINT [FK_mesa_tienda] FOREIGN KEY([idTienda])
REFERENCES [dbo].[tienda] ([idTiendaNit])
GO
ALTER TABLE [dbo].[mesa] CHECK CONSTRAINT [FK_mesa_tienda]
GO
ALTER TABLE [dbo].[pedido]  WITH CHECK ADD  CONSTRAINT [FK_pedido_persona_grupo] FOREIGN KEY([idPersona_Grupo])
REFERENCES [dbo].[persona_grupo] ([idGrupoPersona])
GO
ALTER TABLE [dbo].[pedido] CHECK CONSTRAINT [FK_pedido_persona_grupo]
GO
ALTER TABLE [dbo].[pedido_producto]  WITH CHECK ADD  CONSTRAINT [FK_pedido_producto_pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[pedido] ([idPedido])
GO
ALTER TABLE [dbo].[pedido_producto] CHECK CONSTRAINT [FK_pedido_producto_pedido]
GO
ALTER TABLE [dbo].[pedido_producto]  WITH CHECK ADD  CONSTRAINT [FK_pedido_producto_producto] FOREIGN KEY([idProducto])
REFERENCES [dbo].[producto] ([idProducto])
GO
ALTER TABLE [dbo].[pedido_producto] CHECK CONSTRAINT [FK_pedido_producto_producto]
GO
ALTER TABLE [dbo].[persona]  WITH CHECK ADD  CONSTRAINT [FK_persona_tipo_DNI] FOREIGN KEY([idTipoDNI])
REFERENCES [dbo].[tipo_DNI] ([idTipoDNI])
GO
ALTER TABLE [dbo].[persona] CHECK CONSTRAINT [FK_persona_tipo_DNI]
GO
ALTER TABLE [dbo].[persona_grupo]  WITH CHECK ADD  CONSTRAINT [FK_persona_grupo_persona] FOREIGN KEY([idPersona])
REFERENCES [dbo].[persona] ([idDNIPersona])
GO
ALTER TABLE [dbo].[persona_grupo] CHECK CONSTRAINT [FK_persona_grupo_persona]
GO
ALTER TABLE [dbo].[persona_grupo]  WITH CHECK ADD  CONSTRAINT [FK_PersonaGrupo_Grupo] FOREIGN KEY([idGrupo])
REFERENCES [dbo].[grupo] ([idGrupo])
GO
ALTER TABLE [dbo].[persona_grupo] CHECK CONSTRAINT [FK_PersonaGrupo_Grupo]
GO
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [FK_producto_categoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[categoria] ([idCategoria])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [FK_producto_categoria]
GO
USE [master]
GO
ALTER DATABASE [App_Mi_Tienda] SET  READ_WRITE 
GO
