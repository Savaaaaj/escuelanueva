
package pe.com.escuelanueva.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanueva.entity.ApoderadoEntity;
import pe.com.escuelanueva.repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {
    
    @Autowired
    private ApoderadoRepository repositorioapo;

    @Override
    public List<ApoderadoEntity> findAll() {
        return repositorioapo.findAll();
    }

    @Override
    public List<ApoderadoEntity> findAllCustom() {
        return repositorioapo.findAllCustom();
    }

    @Override
    public Optional<ApoderadoEntity> findById(Long id) {
        return repositorioapo.findById(id);
    }

    @Override
    public ApoderadoEntity add(ApoderadoEntity a) {
        return repositorioapo.save(a);

    }

    @Override
    public ApoderadoEntity update(ApoderadoEntity a) {
        ApoderadoEntity objapoderado= repositorioapo.getById(a.getCodigo());
        BeanUtils.copyProperties(a, objapoderado);
        return repositorioapo.save(objapoderado);
    }

    @Override
    public ApoderadoEntity delete(ApoderadoEntity a) {
        ApoderadoEntity objapoderado= repositorioapo.getById(a.getCodigo());
        objapoderado.setEstado(false);
        return repositorioapo.save(objapoderado);
    }

}
