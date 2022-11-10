
package pe.com.escuelanueva.service;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanueva.entity.DistritoEntity;


public interface DistritoService {
    //función para mostrar todos los datos
    List<DistritoEntity> findAll();
    //función para mostrar los distritos habilitados
    List<DistritoEntity> findAllCustom();
    //función para buscar un distrito por código
    Optional<DistritoEntity> findById(Long id);
    //función para registrar
    DistritoEntity add(DistritoEntity d);
    //función para editar
    DistritoEntity update(DistritoEntity d);
    //función para eliminar
    DistritoEntity delete(DistritoEntity d);
}
