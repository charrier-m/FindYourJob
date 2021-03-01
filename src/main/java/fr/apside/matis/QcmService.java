package fr.apside.matis;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class QcmService {

    Logger logger = Logger.getLogger("mylogger");


    public String getDataFromStream(UserQualitiesDTO dto) throws IOException {

        StringBuilder request = new StringBuilder();
        if(dto.isAgriculture()){
            request.append("agriculture+");
        }
        if(dto.isSocial()){
            request.append("social+");
        }
        if(dto.isMathematiques()){
            request.append("mathematiques+");
        }
        if(dto.isCommerce()) {
            request.append("commerce+");
        }
        if(dto.isMedical()){
            request.append("medical+");
        }
        if(dto.isManager()){
            request.append("manager+");
        }
        if(dto.isInformatique()){
            request.append("informatique");
        }
        //on remplace le dernier '+' en trop par un '&'
        request.setCharAt(request.toString().length()-1, '&');
        //on rajoute la taille
        request.append("size=5");
        logger.info("request from GetDataFromStream = " + request.toString());
        return request.toString();

    }





}
