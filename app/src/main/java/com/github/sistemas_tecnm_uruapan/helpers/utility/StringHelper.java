package com.github.sistemas_tecnm_uruapan.helpers.utility;



import com.github.sistemas_tecnm_uruapan.helpers.models.Alumno;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringHelper
{
    public boolean isPhone(String val)
    {
        String EXREGTEL="\\d{10}";
        return Pattern.matches(EXREGTEL,val);
    }
    public static  String getCarrara(String val)
    {
        String carr = "";
        switch(val)
        {
            case "1":
                carr = "Sistemas";
                break;
            case "3":
                carr = "Industrial";
                break;
            case "4":
                carr = "Alimentarias";
                break;
            case "5":
                carr = "Electrónica";
                break;
            case "6":
                carr = "Mecatrónica";
                break;
            case "7":
                carr = "Mecánica";
                break;
            case "8":
                carr = "Administración";
                break;
            case "9":
                carr = "Sistemas Mixta";
                break;
            case "10":
                carr = "Administración Mixta";
                break;
            case "11":
                carr = "Civil";
                break;
        }
        return carr;
    }
    public ArrayList<Alumno> getData()
    {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno ("15040135","3","CARRANZA CORZA JULIO DAVID","A"));
        alumnos.add(new Alumno ("15040144","3","GAONA PEDRAZA JUAN JOSE","A"));
        alumnos.add(new Alumno ("15040145","3","GARCIA LEON EDGAR","A"));
        alumnos.add(new Alumno ("15040147","3","GARCIA TALAVERA LUIS XAVIER","A"));
        alumnos.add(new Alumno ("15040150","3","HERNANDEZ TORRES GERARDO ALFREDO","A"));
        alumnos.add(new Alumno ("15040194","3","HUERTA MENDOZA MERCEDES GUADALUPE","B"));
        alumnos.add(new Alumno ("15040197","3","MARTINEZ ALONSO JOSE FERNANDO","B"));
        alumnos.add(new Alumno ("15040205","3","PEREZ ALEJANDRE JUAN ","B"));
        alumnos.add(new Alumno ("15040209","3","RIVERA CERVANTES FELIPE","B"));
        alumnos.add(new Alumno ("15040214","3","TAFOLLA ORTIZ JORGE ALEJANDRO","B"));
        alumnos.add(new Alumno ("15040325","3","ESQUIVEL FAJARDO EDGAR ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040230","4","CHAVEZ ZARAGOZA KAREN","A"));
        alumnos.add(new Alumno ("15040262","4","SANDOVAL RAMIREZ JOSE JESUS","A"));
        alumnos.add(new Alumno ("17040730","5","SOLIS MORALES SERGIO DAVID","A"));
        alumnos.add(new Alumno ("13040040","6","AMBROCIO RAZO SANTIAGO","A"));
        alumnos.add(new Alumno ("14040131","6","CUEVAS PADILLA ROLANDO ESAHU","B"));
        alumnos.add(new Alumno ("14040243","7","JUAREZ GONZALEZ TUTANKAMEN ROGELIO","A"));
        alumnos.add(new Alumno ("15040409","7","ARIAS ACOSTA ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040412","7","CARRANZA BRAVO JOSE ADOLFO","A"));
        alumnos.add(new Alumno ("15040413","7","CHAPA GARCIA ULISES","A"));
        alumnos.add(new Alumno ("15040415","7","DE LA LUZ LOPEZ ESTEBAN RODOLFO","A"));
        alumnos.add(new Alumno ("15040419","7","GALVAN AGUILAR MARITZA JUDIT","A"));
        alumnos.add(new Alumno ("15040421","7","GARCIA AGUILAR ITZIA YANETH","A"));
        alumnos.add(new Alumno ("15040424","7","GOMEZ GUTIERREZ ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040428","7","GUIZAR MARTINEZ FELIPE SAUL","A"));
        alumnos.add(new Alumno ("15040432","7","JIMENEZ RODRIGUEZ MARIA GUADALUPE","A"));
        alumnos.add(new Alumno ("15040433","7","JUAREZ GUTIERREZ CARMEN SUHAIL","A"));
        alumnos.add(new Alumno ("15040439","7","MURGUIA VILLAFAN DANIELA GUADALUPE","A"));
        alumnos.add(new Alumno ("15040443","7","RODRIGUEZ RUIZ VERONICA IVETTE","A"));
        alumnos.add(new Alumno ("15040446","7","SANDOVAL DURAN ALEXA IVONNE","A"));
        alumnos.add(new Alumno ("15040455","7","AGUILAR REYES LAURA ISELA","B"));
        alumnos.add(new Alumno ("15040456","7","ALVAREZ VAZQUEZ PAOLA ARELY","B"));
        alumnos.add(new Alumno ("15040459","7","CALDERON MACIEL VICTORIA","B"));
        alumnos.add(new Alumno ("15040462","7","CHAVEZ MARTINEZ PAULINA GUADALUPE","B"));
        alumnos.add(new Alumno ("15040464","7","DE LA CRUZ AVELLANEDA CITLALLI","B"));
        alumnos.add(new Alumno ("15040468","7","ESTRELLA NAVA NAYELI ALEJANDRA","B"));
        alumnos.add(new Alumno ("15040471","7","GONZALEZ CASILLAS WRIEL","B"));
        alumnos.add(new Alumno ("15040474","7","MAGAÑA VIDALES KARINA","B"));
        alumnos.add(new Alumno ("15040484","7","RAYA ARELLANO BRIAN GABRIEL","B"));
        alumnos.add(new Alumno ("15040487","7","SALINAS SANTIAGO LILIANA YAQUELIN","B"));
        alumnos.add(new Alumno ("15040490","7","SARABIA BARAJAS ALAN SINUE","B"));
        alumnos.add(new Alumno ("15040494","7","TALAVERA CASTILLO JESSICA PAULINA","B"));
        alumnos.add(new Alumno ("14040418","8","SANCHEZ ANDRADE ALAN","A"));
        alumnos.add(new Alumno ("15040036","10","VAZQUEZ ACOSTA JOSE ANTONIO","U"));
        alumnos.add(new Alumno ("15040574","10","GONZALEZ ARRIOLA SELENE","U"));
        alumnos.add(new Alumno ("15040587","10","PEREZ GILES NAYELY","U"));
        alumnos.add(new Alumno ("15040141","3","DUARTE BUCIO LUIS ANTONIO","A"));
        alumnos.add(new Alumno ("15040158","3","NARANJO ACOSTA JUAN JOSE","A"));
        alumnos.add(new Alumno ("15040176","3","ANGEL GUERRERO JOSE ARMANDO","B"));
        alumnos.add(new Alumno ("15040181","3","CATALA MEDINA NATHALIE","B"));
        alumnos.add(new Alumno ("15040254","4","PIÑON RIOS MARIA FERNANDA","A"));
        alumnos.add(new Alumno ("15040260","4","SALINAS PEDRAZA VERONICA","A"));
        alumnos.add(new Alumno ("14040111","5","CERVANTES MARTINEZ YESSICA","A"));
        alumnos.add(new Alumno ("13040168","6","GARCIA ARCILA ARMANDO","B"));
        alumnos.add(new Alumno ("15040472","7","HERNANDEZ BARBA LARISSA DAYLE","B"));
        alumnos.add(new Alumno ("15040481","7","QUEZADA HERNANDEZ JUANA DE JESUS","B"));
        alumnos.add(new Alumno ("15040489","7","SANCHEZ RAUDA YUNUEN GUADALUPE","B"));
        alumnos.add(new Alumno ("13040086","8","BRAVO CARO LUIS ALBERTO","A"));
        alumnos.add(new Alumno ("15040128","3","AGUILAR GONZALEZ ANTONIO","A"));
        alumnos.add(new Alumno ("15040131","3","BEDOLLA HERRERA ALICIA GUADALUPE","A"));
        alumnos.add(new Alumno ("15040151","3","ISIDRO CAMPOVERDE ALEX ABRAHAM","A"));
        alumnos.add(new Alumno ("15040187","3","ESTRADA ROSAS GABRIELA","A"));
        alumnos.add(new Alumno ("15040188","3","ESTRELLA GARIBAY LUIS FERNANDO","B"));
        alumnos.add(new Alumno ("15040204","3","PAZ TRONCOSO RAUL ALEJANDRO","B"));
        alumnos.add(new Alumno ("15040540","3","SILVA FLORES LUIS GILBERTO","A"));
        alumnos.add(new Alumno ("15040239","4","GODOY CORONA ALONDRA VALERIA","A"));
        alumnos.add(new Alumno ("15040257","4","REYES GARCIA ARCELIA FERNANDA","A"));
        alumnos.add(new Alumno ("15040259","4","ROCHA DURAN MARIANA","A"));
        alumnos.add(new Alumno ("14040292","5","MELCHOR EQUIHUA DANIEL","A"));
        alumnos.add(new Alumno ("14040404","5","RODRIGUEZ VAZQUEZ ESGARDO","A"));
        alumnos.add(new Alumno ("14040235","6","IBAÑEZ ALVAREZ DANIEL ALEJANDRO","A"));
        alumnos.add(new Alumno ("14040491","6","VARGAS CUEVAS JONATHAN HAFID","A"));
        alumnos.add(new Alumno ("15040407","7","ARELLANO GONZALEZ CINDY RUBI","A"));
        alumnos.add(new Alumno ("15040475","7","MARTINEZ MENDEZ MONICA","B"));
        alumnos.add(new Alumno ("15040491","7","SERVIN MENDOZA ALONDRA","B"));
        alumnos.add(new Alumno ("14040146","8","ESTRELLA BRAVO MIGUEL ANGEL","A"));
        alumnos.add(new Alumno ("15040567","10","CORTEZ RODRIGUEZ DANIELA","U"));
        alumnos.add(new Alumno ("14040223","3","HERNANDEZ MORALES APOLINAR","A"));
        alumnos.add(new Alumno ("14040224","3","HERNANDEZ RUBIO LUIS FERNANDO","B"));
        alumnos.add(new Alumno ("15040212","3","SANCHEZ PATLAN AMELIA ALEJANDRA","B"));
        alumnos.add(new Alumno ("15040406","7","ALONSO GUERRERO ANDREA JESUS","A"));
        alumnos.add(new Alumno ("15040458","7","CALDERON MACIEL MARIA GUADALUPE","B"));
        alumnos.add(new Alumno ("15040480","7","MORALES GONZALEZ CLAUDIA","B"));
        alumnos.add(new Alumno ("15040618","10","LOPEZ CONTRERAS JULIA ANDREA","U"));
        alumnos.add(new Alumno ("15040134","3","BUSTOS ESTRADA ANA MICHAEL","A"));
        alumnos.add(new Alumno ("15040146","3","GARCIA ROSAS EDGAR ENRIQUE","A"));
        alumnos.add(new Alumno ("15040154","3","MEDINA SANCHEZ LUIS FERNANDO","B"));
        alumnos.add(new Alumno ("15040172","3","ZARAGOZA GARCIA CESAR IVAN","A"));
        alumnos.add(new Alumno ("15040174","3","AGUILAR ZUÑIGA MARIA GUADALUPE","B"));
        alumnos.add(new Alumno ("15040189","3","GALVAN CHAVEZ ALEJANDRA","B"));
        alumnos.add(new Alumno ("15040193","3","HERNANDEZ CHAVEZ ARIADNA MICHAEL","A"));
        alumnos.add(new Alumno ("15040195","3","HUERTA OCHOA MAXIMO","B"));
        alumnos.add(new Alumno ("15040248","4","MOLINA VIDALES JOSE MARTIN","A"));
        alumnos.add(new Alumno ("13040097","5","CALVILLO ESPINOSA LUIS ERNESTO","A"));
        alumnos.add(new Alumno ("15040437","7","MELGOZA GUILLEN DIEGO ERICK","A"));
        alumnos.add(new Alumno ("15040448","7","SIMON FELIPE ANA MELISA","A"));
        alumnos.add(new Alumno ("15040454","7","AGUILAR RAMIREZ VICTOR JAVIER","B"));
        alumnos.add(new Alumno ("15040485","7","RODRIGUEZ CRUZ ALONDRA","B"));
        alumnos.add(new Alumno ("15040496","7","TORRES TORRES AMERICA DANIELA","B"));
        alumnos.add(new Alumno ("15040139","3","CASTELLANOS LUCATERO FRANCISCO GUILLERMO","A"));
        alumnos.add(new Alumno ("15040207","3","RAMIREZ VIVEROS BRAYAN","B"));
        alumnos.add(new Alumno ("14040021","6","ALCOCER CEDEÑO IVAN","A"));
        alumnos.add(new Alumno ("14040286","6","MEDINA VAZQUEZ ANDREA ESTEFANIA","A"));
        alumnos.add(new Alumno ("15040457","7","CABRERA REYES HECTOR","B"));
        alumnos.add(new Alumno ("15040600","7","SANCHEZ AYALA DAVID","B"));
        alumnos.add(new Alumno ("14040114","9","CHAVEZ LOPEZ GIOVANNI DICARLO","U"));
        alumnos.add(new Alumno ("14040288","3","MEJIA DUARTE ALAN EDUARDO","B"));
        alumnos.add(new Alumno ("15040258","4","ROBLES PEREZ VALENTINA","A"));
        alumnos.add(new Alumno ("15040414","7","CRUZ VALENCIA LAURA","A"));
        alumnos.add(new Alumno ("15040469","7","FLORES HERNANDEZ DAYSI EDITH","B"));
        alumnos.add(new Alumno ("15040127","3","AGUILAR ANGUIANO AGUSTIN","A"));
        alumnos.add(new Alumno ("15040177","3","BENITEZ FLORES EDUARDO","B"));
        alumnos.add(new Alumno ("15040192","3","GUTIERREZ REYES ALEJANDRA LIZBETH","B"));
        alumnos.add(new Alumno ("15040220","3","VERDUZCO PIMENTEL JONATHAN DANIEL","B"));
        alumnos.add(new Alumno ("15040234","4","FARFAN BECERRA ANDREA MICHELLE","A"));
        alumnos.add(new Alumno ("15040451","7","VAZQUEZ CHAVEZ MARIA FERNANDA","A"));
        alumnos.add(new Alumno ("13040360","1","RAMIREZ BONILLA LUIS BARUCH","A"));
        alumnos.add(new Alumno ("15040182","3","CHAVEZ GUERRA EFRAIN","B"));
        alumnos.add(new Alumno ("15040184","3","CORTES RAYON ANGEL FERNANDO","B"));
        alumnos.add(new Alumno ("15040266","4","ZAVALA VALENCIA ALONDRA","A"));
        alumnos.add(new Alumno ("15040423","7","GARIBAY ESTRADA YAHAIRA ESTEFANIA","A"));
        alumnos.add(new Alumno ("14040052","3","BAEZ AGUADO PEDRO DE JESUS ","B"));
        alumnos.add(new Alumno ("15040156","3","MENDOZA SANCHEZ MARCO ANTONIO","A"));
        alumnos.add(new Alumno ("15040488","7","SANCHEZ CALDERON CINTHIA ESTEFANIA","B"));
        alumnos.add(new Alumno ("15040595","10","RODRIGUEZ MARTINEZ ROSA ELIA","U"));
        alumnos.add(new Alumno ("14040465","3","TINOCO LEMUS GABRIELA JOCELINE","A"));
        alumnos.add(new Alumno ("14040514","3","VILLEGAS RAMIREZ LUIS GERARDO","A"));
        alumnos.add(new Alumno ("15040133","3","BUCIO CHAVEZ JOSE ENRIQUE","B"));
        alumnos.add(new Alumno ("14040174","6","GARCIA MORALES ALEJANDRO ","A"));
        alumnos.add(new Alumno ("15040466","7","ESQUIVEL PURECO JOSE ALFREDO","B"));
        alumnos.add(new Alumno ("15040482","7","RAMIREZ RODRIGUEZ ANAYELI","B"));
        alumnos.add(new Alumno ("13040131","8","CRUZ HERREJON OMAR ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040452","10","VELAZQUEZ GUILLEN JENNIFER JACQUELINE","U"));
        alumnos.add(new Alumno ("15040473","7","MAGAÑA JUAREZ LILIANA GUADALUPE","B"));
        alumnos.add(new Alumno ("15040130","3","BARAJAS CARO JULIO CESAR","A"));
        alumnos.add(new Alumno ("15040159","3","NAVA SANCHEZ MARCO ADALID","B"));
        alumnos.add(new Alumno ("15040256","4","RAMIREZ DIMAS ALMA LIZETH","A"));
        alumnos.add(new Alumno ("13040326","9","OCHOA BARRETO JOSE URIEL","U"));
        alumnos.add(new Alumno ("13040298","10","MENDEZ MINCHACA APOLINAR JUAN ABRAHAM","U"));
        alumnos.add(new Alumno ("15040162","3","RAMIREZ PEDRAZA DANIEL ALEJANDRO","A"));
        alumnos.add(new Alumno ("16040016","3","CORTES RAMIREZ MARTHA ELIZABETH","A"));
        alumnos.add(new Alumno ("13040403","1","RUIZ HIDALGO LIZBETH","A"));
        alumnos.add(new Alumno ("15040245","4","LEON RANGEL CAROLINA","A"));
        alumnos.add(new Alumno ("14040314","5","MORA AVILA IVAN","A"));
        alumnos.add(new Alumno ("13040351","5","PEREZ ZIRANDA DANIEL","A"));
        alumnos.add(new Alumno ("15040483","7","RAMIREZ SUAREZ TERESA ITZEL","B"));
        alumnos.add(new Alumno ("16040014","4","BENAVENTE VAZQUEZ ANA MARGARITA","A"));
        alumnos.add(new Alumno ("14040220","6","HERNANDEZ MARTINEZ JESUS","B"));
        alumnos.add(new Alumno ("15040249","4","NEGRETE ALVARADO ITZEL","A"));
        alumnos.add(new Alumno ("15040175","3","ALVAREZ PADILLA LUIS ALBERTO","B"));
        alumnos.add(new Alumno ("15040200","3","MEDINA BARAJAS CRISTIAN CUAUHTEMOC","B"));
        alumnos.add(new Alumno ("14040033","5","ALVAREZ CAMPOS LUIS RODRIGO","A"));
        alumnos.add(new Alumno ("15040430","7","HERNANDEZ GARCIA JESSICA ROCIO","A"));
        alumnos.add(new Alumno ("15040224","4","BACA QUINTERO VIVIANA BERENICE","A"));
        alumnos.add(new Alumno ("14040074","5","BUENAVENTURA GONZALEZ REYNALDO ELISEO","A"));
        alumnos.add(new Alumno ("14040419","4","SANCHEZ CELIS JUDITH","A"));
        alumnos.add(new Alumno ("15040264","4","SOLORIO MENDOZA ARELI","A"));
        alumnos.add(new Alumno ("14040310","1","MONROY BARBOSA CHRISTIAN JOVANY","A"));
        alumnos.add(new Alumno ("15040053","1","GARCIA ARREGUIN ROLANDO","A"));
        alumnos.add(new Alumno ("15040060","1","LEON MUJICA CARLOS ALFREDO","A"));
        alumnos.add(new Alumno ("15040084","1","ALCAZAR JURADO JONATHAN ZACEK","B"));
        alumnos.add(new Alumno ("15040093","1","GOMEZ AMBRIZ EMMANUEL ANTONIO","B"));
        alumnos.add(new Alumno ("15040104","1","MEZA ARRIAGA PAULA ROCIO ","B"));
        alumnos.add(new Alumno ("15040105","1","MORA NUÑEZ SAMIR","B"));
        alumnos.add(new Alumno ("15040108","1","OROZCO EQUIHUA ALEJANDRO ISRAEL","B"));
        alumnos.add(new Alumno ("15040124","1","ZALAPA MEDINA EDUARDO","B"));
        alumnos.add(new Alumno ("15040125","1","ZAMBRANO RODRIGUEZ CARLOS","B"));
        alumnos.add(new Alumno ("15040275","5","CHAVEZ BRAVO RUBEN","A"));
        alumnos.add(new Alumno ("15040314","6","ALEJO RAMOS JOSE ANTONIO","B"));
        alumnos.add(new Alumno ("15040339","6","MENDOZA VALENCIA ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040348","6","RODRIGUEZ MARTINEZ JEZEL","A"));
        alumnos.add(new Alumno ("15040366","6","CARDOSO DE LA FUENTE ERIK ALEXIS","B"));
        alumnos.add(new Alumno ("15040372","6","GONZALEZ CASTAÑEDA JESUS DAVID","B"));
        alumnos.add(new Alumno ("15040378","6","LOPEZ DIAZ OTILIO EFREN","B"));
        alumnos.add(new Alumno ("15040392","6","RAMIREZ DIAZ CARLOS ANDRES","B"));
        alumnos.add(new Alumno ("15040394","6","RODRIGUEZ MARTINEZ JAIRO","B"));
        alumnos.add(new Alumno ("15040404","6","VAZQUEZ CERVANTES JONATHAN ALFREDO","B"));
        alumnos.add(new Alumno ("14040468","7","TORAN MURILLO JHONATAN ALEJANDRO","B"));
        alumnos.add(new Alumno ("15040435","7","MARTINEZ RODRIGUEZ VIRIDIANA","A"));
        alumnos.add(new Alumno ("15040441","7","PULIDO ANGEL VANESA","A"));
        alumnos.add(new Alumno ("15040514","8","HERNANDEZ VILLAGOMEZ JOSE SAUL","A"));
        alumnos.add(new Alumno ("15040642","9","CEJA MELGOZA RODRIGO","P"));
        alumnos.add(new Alumno ("15040561","10","ABARCA JUAREZ VERONICA TANAIRI","U"));
        alumnos.add(new Alumno ("15040585","10","MUÑOZ GALVAN JOSE ANGEL","U"));
        alumnos.add(new Alumno ("15040624","10","CHAVEZ MARTINEZ MA EUGENIA","P"));
        alumnos.add(new Alumno ("15040627","10","GARCIA GARCIA ALONDRA ITZEL","P"));
        alumnos.add(new Alumno ("15040628","10","GUILLEN ALVARADO TERESA DE JESUS","P"));
        alumnos.add(new Alumno ("15040631","10","LOPEZ DUARTE LAURA GUADALUPE","P"));
        alumnos.add(new Alumno ("15040665","10","GARCIA OROZCO MAYRA ALEJANDRA","P"));
        alumnos.add(new Alumno ("16040586","10","MARTINEZ VIVEROS ANA ISABEL","U"));
        alumnos.add(new Alumno ("15040107","1","OCHOA VILLA CARLOS ULISES","B"));
        alumnos.add(new Alumno ("15040617","5","JASSO VELEZ ELIAS","A"));
        alumnos.add(new Alumno ("15040374","6","HERNANDEZ BARRIGA JAIME RODOLFO","B"));
        alumnos.add(new Alumno ("15040397","6","SALOME MURILLO ESTEBAN","B"));
        alumnos.add(new Alumno ("15040650","9","NAREZ PAROCUA ROSELIA","P"));
        alumnos.add(new Alumno ("15040619","10","AGUILERA RAMIREZ ROSARIO","P"));
        alumnos.add(new Alumno ("15040636","10","NUÑEZ ZAVALA ALEJANDRA","P"));
        alumnos.add(new Alumno ("15040637","10","OCHOA CERDA ANA JULIA","P"));
        alumnos.add(new Alumno ("15040123","1","VILLANUEVA ESTRADA ARLETH","B"));
        alumnos.add(new Alumno ("15040316","6","AVILA AMBRIZ CARLOS EDUARDO","A"));
        alumnos.add(new Alumno ("15040341","6","MONTAÑEZ CURIEL MARIO ADRIAN","A"));
        alumnos.add(new Alumno ("15040425","7","GONZALEZ CORTES PATSY MARNELLY","A"));
        alumnos.add(new Alumno ("15040515","8","HUERTA GARCIA JUAN JOSE","A"));
        alumnos.add(new Alumno ("15040531","8","RAMA SANDOVAL CAYETANO","A"));
        alumnos.add(new Alumno ("15040042","1","BRAVO MORENO ABRAHAM PATRICIO","A"));
        alumnos.add(new Alumno ("15040065","1","MEDIANO TINOCO RAUL","A"));
        alumnos.add(new Alumno ("15040115","1","ROMERO ZEPEDA AMAURY VALENTIN","B"));
        alumnos.add(new Alumno ("15040381","6","MARES LOPEZ VICTOR FERNANDO","B"));
        alumnos.add(new Alumno ("15040388","6","MURILLO BAÑALES JESUS","B"));
        alumnos.add(new Alumno ("15040391","6","PONCE ACOSTA DANTE HERIBERTO","B"));
        alumnos.add(new Alumno ("15040518","8","LOPEZ AGUILAR ULISES SALVADOR","A"));
        alumnos.add(new Alumno ("15040520","8","MARTINEZ CORDOBA ANGEL ISAI","A"));
        alumnos.add(new Alumno ("15040652","9","OCHOA CERDA MARTHA ALICIA","P"));
        alumnos.add(new Alumno ("15040662","9","RUIZ REYES EDITH","P"));
        alumnos.add(new Alumno ("15040088","1","CIPRES MEDINA EDGAR ULISES","B"));
        alumnos.add(new Alumno ("15040101","1","MEDRANO GOMEZ ALAN ALEXIS","B"));
        alumnos.add(new Alumno ("15040106","1","MORENO ROMERO CARLOS FABIAN","B"));
        alumnos.add(new Alumno ("15040243","4","HINOJOSA CHAVEZ JORGE ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040284","5","HERRERA GARCIA ROBERTO DARIO","A"));
        alumnos.add(new Alumno ("15040639","10","SANCHEZ MELGOZA MAYRA ALEJANDRA","P"));
        alumnos.add(new Alumno ("15040112","1","PATLAN CARRERA MORELIA LYANNETH","B"));
        alumnos.add(new Alumno ("15040299","5","RODRIGUEZ PEREZ LUIS ANGEL","A"));
        alumnos.add(new Alumno ("14040088","6","CAMPOS FERREIRA ROBERTO","A"));
        alumnos.add(new Alumno ("15040075","6","RAMIREZ GARCIA JORGE ARTURO","B"));
        alumnos.add(new Alumno ("15040330","6","HERNANDEZ ALVAREZ JOSE MIGUEL","A"));
        alumnos.add(new Alumno ("15040365","6","CARDENAS CABALLERO CESAR JAFET","B"));
        alumnos.add(new Alumno ("15040064","1","MARTINEZ CRISTAL JOSE DAVID","A"));
        alumnos.add(new Alumno ("15040122","1","VILLA RODRIGUEZ ABIGAIL","B"));
        alumnos.add(new Alumno ("15040186","3","ELIAS CASTAÑEDA CARLOS ALBERTO","B"));
        alumnos.add(new Alumno ("15040219","3","VAZQUEZ SOLIS ISRAEL","B"));
        alumnos.add(new Alumno ("15040360","6","ALFARO RAMIREZ ERNESTO ALEJANDRO","B"));
        alumnos.add(new Alumno ("15040537","8","RUIZ GONZALEZ OMAR ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040658","9","REYES ESQUIVEL RAFAEL","P"));
        alumnos.add(new Alumno ("15040623","10","CHAVEZ CASTRO GUADALUPE","P"));
        alumnos.add(new Alumno ("15040199","3","MARTINEZ VILLANUEVA CESAR","B"));
        alumnos.add(new Alumno ("14040355","5","PAREDES NARANJO DANIEL","A"));
        alumnos.add(new Alumno ("15040265","4","VILLEGAS MARTINEZ DANIELA","A"));
        alumnos.add(new Alumno ("15040503","8","BAÑUELOS MONDRAGON GABRIEL ALEJANDRO","A"));
        alumnos.add(new Alumno ("15040527","8","ORTIZ LEON MANUEL ABRAHAM","A"));
        alumnos.add(new Alumno ("15040649","9","MORENO CUEVAS EDUARDO","P"));
        alumnos.add(new Alumno ("15040656","9","RAMIREZ ADAME LUIS","P"));
        alumnos.add(new Alumno ("15040038","1","AGUILAR LOPEZ JORGE EDUARDO","A"));
        alumnos.add(new Alumno ("14040353","5","PAREDES MARTINEZ IGNACIO","A"));
        alumnos.add(new Alumno ("15040273","5","BERNAL VEGA MIGUEL AMBROSIO","A"));
        alumnos.add(new Alumno ("14040447","6","SOLIS SAUCEDO LUIS SEBASTIAN","A"));
        alumnos.add(new Alumno ("15040270","5","ALVEZ FLORES DANIEL","A"));
        alumnos.add(new Alumno ("15040294","5","PEREZ ROJAS CESAR EDUARDO","A"));
        alumnos.add(new Alumno ("15040626","10","GARCIA DUARTE MARTHA ALICIA","P"));
        alumnos.add(new Alumno ("15040535","8","ROMAN SOLORZANO JESUS","A"));
        alumnos.add(new Alumno ("15040271","5","AMBRIZ GUILLEN JESUS BULMARO","A"));
        alumnos.add(new Alumno ("15040534","8","ROMAN SOLORZANO JAVIER","A"));
        alumnos.add(new Alumno ("15040646","9","MAGAÑA HURTADO JOSE DAVID","P"));
        alumnos.add(new Alumno ("15040638","10","RIVERA VEGA LUZ HERMINIA","P"));
        alumnos.add(new Alumno ("14040271","5","MARTINEZ BRAVO RAUL","A"));
        alumnos.add(new Alumno ("15040592","10","REYES LOPEZ MARIA ELENA","U"));
        alumnos.add(new Alumno ("15040312","5","ZAMORA MENDOZA LUIS DAVID","A"));
        alumnos.add(new Alumno ("14040357","9","PATLAN CARRERA MARIO ALBERTO","U"));
        alumnos.add(new Alumno ("14040173","6","GARCIA MENDOZA EDGAR OMAR","A"));
        alumnos.add(new Alumno ("15040161","3","PEREZ CALDERON MARIA MONSERRAT","A"));
        alumnos.add(new Alumno ("16040568","10","CERANO BRIBIESCA HAYDEE GABRIELA","U"));
        alumnos.add(new Alumno ("15040140","3","CASTILLO ZAMUDIO OMAR JALIL","A"));
        alumnos.add(new Alumno ("15040269","5","ALVAREZ SILVA JESUS FERNANDO","A"));
        alumnos.add(new Alumno ("15040622","10","CENDEJAS MARTINEZ CLAUDIA","P"));


        return alumnos;
    }
}
