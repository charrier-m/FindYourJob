package fr.apside.matis.service;

import fr.apside.matis.DTO.UserQualitiesDTO;

import java.io.IOException;

public class QcmService {

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
        request.setCharAt(request.toString().length()-1, '&');
        request.append("size=5");

        return request.toString();

    }





}
