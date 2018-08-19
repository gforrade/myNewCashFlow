package ar.gaf.mycashflow;

import ar.gaf.mycashflow.dao.*;
import ar.gaf.mycashflow.model.entities.CentroCosto;
import ar.gaf.mycashflow.model.entities.Egreso;
import ar.gaf.mycashflow.model.entities.EgresoEfectivo;
import ar.gaf.mycashflow.model.entities.EgresoTarjetaCredito;
import ar.gaf.mycashflow.security.WebSecurityConfig;
import ar.gaf.mycashflow.service.BusinessService;
import ar.gaf.mycashflow.service.BusinessServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ComponentScan
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}


	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CentroCostoRepository centroCostoRepository;

	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;

	@Autowired
	private EgresoTarjetaCreditoRepository egresoTarjetaCreditoRepository;

	@Autowired
	private EgresoEfectivoRepository egresoEfectivoRepository;

	@Bean
	public BusinessService businessService() {
		return new BusinessServiceImpl();
	}


	@Bean
	public CommandLineRunner getCentroCostos() {
		return (args) -> {
			businessService().findAllCentrosCosto().forEach( (CentroCosto m) -> System.out.println(m.getNombre()));
		};
	};

	@Bean
	public AuthenticationUserDetailsService<?> getUserDetailsService() {
		return new WebSecurityConfig.PreAuthorizationUserDetailsService();
	}



/*
	@Bean
	public CommandLineRunner insertEgresoTarjetaCredito() {
		return (args) -> {
			EgresoTarjetaCredito egresoTarjetaCredito = new EgresoTarjetaCredito();
			egresoTarjetaCredito.setAnio(2016);
			egresoTarjetaCredito.setDia(24);
			egresoTarjetaCredito.setDescripcion("Gasto con Categoria");
			egresoTarjetaCredito.setFechaCompra(Calendar.getInstance().getTime());
			egresoTarjetaCredito.setImporte(new Double(7500));
			egresoTarjetaCredito.getTarjetaCredito().setId(3L);
			egresoTarjetaCredito.setCantidadCuotas(3);
			egresoTarjetaCredito.getCategoria().setId(115L);
			businessService().saveEgresoTarjetaCredito(egresoTarjetaCredito);
		};
	};

*/

/*
	@Bean
	public CommandLineRunner insertEgresoTarjetaCredito() {
		return (args) -> {
			EgresoTarjetaCredito egresoTarjetaCredito = new EgresoTarjetaCredito();
			egresoTarjetaCredito.setAnio(2016);
			egresoTarjetaCredito.setDia(24);
			egresoTarjetaCredito.setDescripcion("Gasto Fiesta DIa de la Patria");
			egresoTarjetaCredito.setFechaCompra(Calendar.getInstance().getTime());
			egresoTarjetaCredito.setImporte(new Double(12000));
			egresoTarjetaCredito.setCategoria(categoriaRepository.findOne(100L));
			egresoTarjetaCredito.setTarjetaCredito(tarjetaCreditoRepository.findOne(1L));
			egresoTarjetaCredito.setCantidadCuotas(12);
			egresoTarjetaCreditoRepository.save(egresoTarjetaCredito);
		};
	};

*/
/*
	@Bean
	public CommandLineRunner insertEgresoTarjetaCredito() {
		return (args) -> {
			EgresoEfectivo egresoEfectivo = new EgresoEfectivo();
			egresoEfectivo.setAnio(2016);
			egresoEfectivo.setDia(24);
			egresoEfectivo.setFechaCompra(Calendar.getInstance().getTime());
			egresoEfectivo.setImporte(new Double(10000));
			egresoEfectivo.setCategoria(categoriaRepository.findOne(100L));
			egresoEfectivo.setDescripcion("Gasto de pruebas");
			egresoEfectivoRepository.save(egresoEfectivo);
		};
	};

 */


/*
	@Bean
	public CommandLineRunner insertEgresoTarjetaCredito() {
		return (args) -> {
			Categoria categoria = categoriaRepository.findOne(100L);
			TarjetaCredito tarjetaCredito = tarjetaCreditoRepository.findOne(1L);
			EgresoTarjetaCredito egresoTarjetaCredito = new EgresoTarjetaCredito(categoria, 1000D , "gasto de gaby ", new Date(System.currentTimeMillis()) , tarjetaCredito , 12);
			egresoTarjetaCreditoRepository.save(egresoTarjetaCredito);
		};
	};
*/


/*
	@Bean
	public CommandLineRunner insertEgresoTarjetaCredito() {
		return (args) -> {
			Categoria categoria = categoriaRepository.findOne(100L);
			TarjetaCredito tarjetaCredito = tarjetaCreditoRepository.findOne(1L);
			EgresoTarjetaCredito egresoTarjetaCredito = new EgresoTarjetaCredito(categoria, 1000D , "gasto de gaby ", new Date(System.currentTimeMillis()) , tarjetaCredito , 12);
			egresoTarjetaCreditoRepository.save(egresoTarjetaCredito);
		};
	};
*/

/*
	@Bean
	public CommandLineRunner readEgresoTarjetaCredito() {
		return (args) -> {
			EgresoTarjetaCredito egresoTarjetaCredito =  egresoTarjetaCreditoRepository.findOne(1L);
			System.out.println(egresoTarjetaCredito);
			System.out.println(egresoTarjetaCredito.getTarjetaCredito());
			System.out.println(egresoTarjetaCredito.getCategoria());
			System.out.println(egresoTarjetaCredito.getCategoria().getCentroCosto());
			//System.out.println(egresoTarjetaCredito.getCategoria().getGrupo().getNombre());
			System.out.println(egresoTarjetaCredito.getImporte());
			System.out.println(egresoTarjetaCredito.getDescripcion());

		};

	};
*/



	/*
	@Bean
	public CommandLineRunner insertGrupoGastos(GrupoRepository repository) {
		return (args) -> {
			repository.save(new Grupo("Vivienda",""));
			repository.save(new Grupo("Transporte",""));
			repository.save(new Grupo("Impuestos",""));
			repository.save(new Grupo("Educacion",""));
			repository.save(new Grupo("Tarjetas Credito",""));
			repository.save(new Grupo("Esparcimiento",""));
			repository.save(new Grupo("Alimentacion",""));
			repository.save(new Grupo("Prestamos",""));
			repository.save(new Grupo("Salud",""));
			repository.save(new Grupo("Extras",""));
		};
	};

	@Bean
	public CommandLineRunner insertCentroCostos(CentroCostoRepository repository) {
		return (args) -> {
			repository.save(new CentroCosto("Gaby","Centro Costo Gaby"));
			repository.save(new CentroCosto("Caro","Centro Costo Caro"));
			repository.save(new CentroCosto("Hijos","Centro Costo Hijos"));
			repository.save(new CentroCosto("Varios","Centro Costo Varios"));
			repository.save(new CentroCosto("Dto Caro","Centro Costo Familia"));
			repository.save(new CentroCosto("Casa Medano","Centro Costo Super Caro"));
		};
	}


	@Bean
	public CommandLineRunner insertTarjetasCredito(TarjetaCreditoRepository repository) {
		return (args) -> {
			TarjetaCredito tarjetaCredito = new TarjetaCredito("Visa Santander Rio", "VISA", "Banco Santander Rio");
			FechaTarjeta  fechaTarjeta= null;
			List<FechaTarjeta> fechas = new ArrayList<>();

			for (int i=0;i<12;i++) {
				Calendar cal = Calendar.getInstance();
				cal.set(2016,i,24);
				fechas.add(new FechaTarjeta(cal.getTime(),tarjetaCredito));
			}

			tarjetaCredito.setFechasCierre(fechas);


			repository.save(tarjetaCredito);
			repository.save(new TarjetaCredito("Visa ICBC", "VISA", "Banco ICBC"));
			repository.save(new TarjetaCredito("Visa Hipotecario", "VISA", "Banco Hipotecario"));
			repository.save(new TarjetaCredito("CMR", "CMR", "Falabella"));
			repository.save(new TarjetaCredito("Amex SantanderRio", "AMEX", "Banco Santander Rio"));
			repository.save(new TarjetaCredito("American Express", "AMEX", "American Express"));
		};
	};

*/

	/*
	@Bean
	public CommandLineRunner insertTipoGasto(CategoriaRepository repository) {
		return (args) -> {



			repository.save(new Categoria("Clinica Luang","	Gastos Luang",  Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Extras"), centroCostoRepository.findByNombre("Caro")));

			repository.save(new Categoria("Expensas Dto Caro","	Descripcion de nombre	", Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Expensas Medano","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));
			repository.save(new Categoria("Celular Caro","	Descripcion de nombre	",	   Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Luz Medano","	Descripcion de nombre	",	  Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));
			repository.save(new Categoria("Luz Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Municipalidad Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Gas Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Agua Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Alquiler Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("DirecTV Medano","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));
			repository.save(new Categoria("DirecTV Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("Jardinero Medano","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));
			repository.save(new Categoria("Empleada Medano","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));
			repository.save(new Categoria("Speedy Dto Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Dto Caro")));
			repository.save(new Categoria("xFly Medano","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Vivienda"), centroCostoRepository.findByNombre("Casa Medano")));

			repository.save(new Categoria("Seguro Clio","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Patente Clio","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Nafta Clio","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Seguro 308","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Patente 308","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Nafta 308","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Transporte"), centroCostoRepository.findByNombre("Gaby")));



			repository.save(new Categoria("Monotributo","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Impuestos"), centroCostoRepository.findByNombre("Caro")));

			repository.save(new Categoria("OSDE","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Salud"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Sicologo Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Salud"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Sicologo Gaby","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Salud"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Sicologo Tomi","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Salud"), centroCostoRepository.findByNombre("Hijos")));

			repository.save(new Categoria("Gastos Mantenimento Tarjetas	","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Tarjetas Credito"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Hijos","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Tarjetas Credito"), centroCostoRepository.findByNombre("Hijos")));
			repository.save(new Categoria("Gaby","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Tarjetas Credito"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Tarjetas Credito"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Varios","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Tarjetas Credito"), centroCostoRepository.findByNombre("Varios")));

			repository.save(new Categoria("Cuota Colegio Tomas","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Educacion"), centroCostoRepository.findByNombre("Hijos")));
			repository.save(new Categoria("Cuota Colegio Ana Paula","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Educacion"), centroCostoRepository.findByNombre("Hijos")));repository.save(new Categoria("Rugby","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Esparcimiento"), centroCostoRepository.findByNombre("Hijos")));

			repository.save(new Categoria("Danza","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Esparcimiento"), centroCostoRepository.findByNombre("Hijos")));
			repository.save(new Categoria("Gimnasio Gaby","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Esparcimiento"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Natacion Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Esparcimiento"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Salidas Gaby","	Salidas	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Esparcimiento"), centroCostoRepository.findByNombre("Gaby")));

			repository.save(new Categoria("Cuota 308","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Prestamos"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Cuota Clio","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Prestamos"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Prestamo Personal","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Prestamos"), centroCostoRepository.findByNombre("Gaby")));
			repository.save(new Categoria("Credito Hipotecario","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Prestamos"), centroCostoRepository.findByNombre("Gaby")));

			repository.save(new Categoria("Supermercado Caro","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Alimentacion"), centroCostoRepository.findByNombre("Caro")));
			repository.save(new Categoria("Supermercado Gaby","	Descripcion de nombre	",	 Categoria.Tipo.EGRESO, grupoRepository.findByNombre("Alimentacion"), centroCostoRepository.findByNombre("Gaby")));

		};
	};
*/


}
