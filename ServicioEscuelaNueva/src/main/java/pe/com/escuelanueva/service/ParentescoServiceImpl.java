package pe.com.escuelanueva.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanueva.entity.ParentescoEntity;
import pe.com.escuelanueva.repository.ParentescoRepository;

@Service
public class ParentescoServiceImpl implements ParentescoService {

    @Autowired
    private ParentescoRepository repositoriopar;

    @Override
    public List<ParentescoEntity> findAll() {
        return repositoriopar.findAll();
    }

    @Override
    public List<ParentescoEntity> findAllCustom() {
        return repositoriopar.findAllCustom();
    }

    @Override
    public Optional<ParentescoEntity> findById(Long id) {
        return repositoriopar.findById(id);
    }

    @Override
    public ParentescoEntity add(ParentescoEntity p) {
        return repositoriopar.save(p);

    }

    @Override
    public ParentescoEntity update(ParentescoEntity p) {
        ParentescoEntity objparentesco= repositoriopar.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objparentesco);
        return repositoriopar.save(objparentesco);
    }

    @Override
    public ParentescoEntity delete(ParentescoEntity p) {
        ParentescoEntity objparentesco= repositoriopar.getById(p.getCodigo());
        objparentesco.setEstado(false);
        return repositoriopar.save(objparentesco);
    }

}
