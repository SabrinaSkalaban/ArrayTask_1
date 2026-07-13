package by.sabrina.arraytask1.observer.impl;

import by.sabrina.arraytask1.entity.ArrayData;
import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.observer.Observer;
import by.sabrina.arraytask1.service.ArrayCalculationService;
import by.sabrina.arraytask1.service.impl.ArrayCalculationServiceImpl;
import by.sabrina.arraytask1.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObserverImpl implements Observer {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onUpdate(ArrayEntity entity) {
        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        int sum = service.sum(entity).orElse(0);
        double avg = service.average(entity).orElse(0.0);
        int min = service.findMin(entity).orElse(0);
        int max = service.findMax(entity).orElse(0);

        ArrayData data = new ArrayData(sum, avg, min, max);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(entity.getId(), data);

        logger.info("Warehouse updated for array ID: {}", entity.getId());
    }
}