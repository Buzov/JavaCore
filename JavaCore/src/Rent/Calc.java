package Rent;

public class Calc {
	// константы на тарифы
    final double FEE_AREA_1m3 = 4.84;
    final double HOUSE_HEATING_1Gkal = 150.56;
    final double HOT_WATER_1m3 = 13;
    final double COLD_WATER_1m3 = 2.87;
    final double ELECTRICITY_1kw_h = 0.18;
    
    // переменные, с данными плательщика по параметрам, закрыты для внешнего доступа через private
    // им данные будут присвоены только через конструктор класса
    private double feeArea;
    private double houseHeating;
    private double hotWater;
    private double coldWater;
    private double electricity;
    
    Calc (double fee, double house, double hot, double cold, double electr) {
        feeArea = fee;
        houseHeating = house;
        hotWater = hot;
        coldWater = cold;
        electricity = electr;
    }
 
    // подсказка с тарифами за 1 единицу потребляемого ресурса
    void printTarifs() {
        System.out.println("1. Плата за жил.площадь 1м3 = " + FEE_AREA_1m3);
        System.out.println("2. Центральное отопление 1Гкал = " + HOUSE_HEATING_1Gkal);
        System.out.println("3. Холодное водоснабжение и водоотвод 1м3 = " + HOT_WATER_1m3);
        System.out.println("4. Горячее водоснабжение и водоотвод 1м3 = " + COLD_WATER_1m3);
        System.out.println("5. Электроэнергия согласно Постановления НКРЭ Украины 1м3 = " + ELECTRICITY_1kw_h);
    }
    
    // печать суммарной "таксы"
    void printSumTaxes() {
        printTarifs();
        System.out.println("= 1. " + feeArea + "*" + FEE_AREA_1m3 + " = " + feeArea * FEE_AREA_1m3 + "грн");
        System.out.println("= 2. " + houseHeating + "*" + HOUSE_HEATING_1Gkal + " = " + houseHeating * HOUSE_HEATING_1Gkal + "грн");
        System.out.println("= 3. " + hotWater + "*" + HOT_WATER_1m3 + " = " + hotWater * HOT_WATER_1m3 + "грн");
        System.out.println("= 4. " + coldWater + "*" + COLD_WATER_1m3 + " = " + coldWater * COLD_WATER_1m3 + "грн");
        System.out.println("= 5. " + electricity + "*" + ELECTRICITY_1kw_h + " = " + electricity * ELECTRICITY_1kw_h + "грн");
    }
}
