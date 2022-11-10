
package pe.com.escuelanueva.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanueva.entity.DistritoEntity;
import pe.com.escuelanueva.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private DistritoRepository repositoriodis;
    
    
    @Override
    public List<DistritoEntity> findAll() {
        return repositoriodis.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return repositoriodis.findAllCustom();
       
    }

    @Override
    public Optional<DistritoEntity> findById(Long id) {
        return repositoriodis.findById(id);
    }

    @Override
    public DistritoEntity add(DistritoEntity d) {
        return repositoriodis.save(d);
    }

    @Override
    public DistritoEntity update(DistritoEntity d) {
        DistritoEntity objdistrito= repositoriodis.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objdistrito);
        return repositoriodis.save(objdistrito);
    }

    @Override
    public DistritoEntity delete(DistritoEntity d) {
        DistritoEntity objdistrito= repositoriodis.getById(d.getCodigo());
        objdistrito.setEstado(false);
        return repositoriodis.save(objdistrito);
    }
    
}
