package tm.service;

import com.alibaba.fescar.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tm.bean.Storage;
import tm.dao.StorageMapper;

import java.awt.image.ImagingOpException;
import java.io.IOException;

@Service(value = "storageService")
@Transactional
public class StorageServiceImpl implements StorageService {

    private Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, int count) {

        LOGGER.info("Storage Service Begin ... xid: " + RootContext.getXID());

        Storage storage = new Storage();
        storage.setCount(count);
        storage.setCommodityCode(commodityCode);
        storageMapper.updateForOrder(storage);

        LOGGER.info("Storage Service End ... ");

    }
}
