import java.awt.geom.Point2D;
import java.util.HashMap;

import com.bbn.openmap.proj.coords.LatLonPoint;

public class Radar implements IRadar {

    //double[Lat,Lon,X,Y,RadarHeight] -> Don't forget that Y is latitude and X is longitude
    protected static HashMap<String, double[]> Radars = new HashMap<String, double[]>();

    protected String radarName;

    private Radar() {
        //If it is empty, do initialize the radars
        if (Radars.isEmpty()) {
            //Initialize all radars with their coordination
            Radars.put("KABR", new double[]{45.456000, -98.413000, -1102460.950000, 1207729.970000, 1302.000000});
            Radars.put("KABX", new double[]{35.150000, -106.824000, -1991098.570000, 247315.160000, 5870.000000});
            Radars.put("KAKQ", new double[]{36.984000, -77.007000, 601088.300000, 233965.890000, 112.000000});
            Radars.put("KAMA", new double[]{35.233000, -101.709000, -1548798.600000, 164283.490000, 3587.000000});
            Radars.put("KAMX", new double[]{25.611000, -80.413000, 352954.600000, -1004082.010000, 14.000000});
            Radars.put("KAPX", new double[]{44.907000, -84.720000, -55705.440000, 1067472.310000, 1464.000000});
            Radars.put("KARX", new double[]{43.823000, -91.191000, -564446.880000, 970022.660000, 1276.000000});
            Radars.put("KATX", new double[]{48.194000, -122.496000, -2766592.480000, 1973742.750000, 494.000000});
            Radars.put("KBBX", new double[]{39.496000, -121.632000, -3059184.860000, 1072684.430000, 173.000000});
            Radars.put("KBGM", new double[]{42.200000, -75.985000, 643244.650000, 799854.330000, 1606.000000});
            Radars.put("KBHX", new double[]{40.498000, -124.292000, -3220909.080000, 1256838.540000, 2402.000000});
            Radars.put("KBIS", new double[]{46.771000, -100.761000, -1256157.180000, 1377777.860000, 1658.000000});
            Radars.put("KBIX", new double[]{30.524000, -88.985000, -463640.470000, -468425.440000, 136.000000});
            Radars.put("KBLX", new double[]{45.854000, -108.607000, -1858689.230000, 1403430.480000, 3598.000000});
            Radars.put("KBMX", new double[]{33.172000, -86.770000, -249730.540000, -192424.650000, 645.000000});
            Radars.put("KBOX", new double[]{41.956000, -71.137000, 1033959.260000, 814833.490000, 118.000000});
            Radars.put("KBRO", new double[]{25.916000, -97.419000, -1312147.090000, -888069.810000, 23.000000});
            Radars.put("KBUF", new double[]{42.949000, -78.737000, 418329.530000, 865884.600000, 693.000000});
            Radars.put("KBYX", new double[]{24.598000, -81.703000, 228612.550000, -1117952.210000, 8.000000});
            Radars.put("KCAE", new double[]{33.949000, -81.118000, 257393.460000, -108878.620000, 231.000000});
            Radars.put("KCBW", new double[]{46.039000, -67.806000, 1227137.650000, 1291641.680000, 746.000000});
            Radars.put("KCBX", new double[]{43.491000, -116.236000, -2499326.440000, 1325243.690000, 3061.000000});
            Radars.put("KCCX", new double[]{40.923000, -78.004000, 489808.140000, 650810.890000, 2405.000000});
            Radars.put("KCLE", new double[]{41.413000, -81.860000, 173763.320000, 690642.680000, 763.000000});
            Radars.put("KCLX", new double[]{32.656000, -81.042000, 268332.820000, -247239.970000, 97.000000});
            Radars.put("KCRI", new double[]{35.238000, -97.460000, -1179790.200000, 106073.380000, 1295.000000});
            Radars.put("KCRP", new double[]{27.784000, -97.511000, -1293503.530000, -686593.810000, 45.000000});
            Radars.put("KCXX", new double[]{44.511000, -73.167000, 841179.840000, 1070390.780000, 317.000000});
            Radars.put("KCYS", new double[]{41.152000, -104.806000, -1682939.010000, 838648.150000, 6128.000000});
            Radars.put("KDAX", new double[]{38.501000, -121.678000, -3102565.090000, 974902.720000, 30.000000});
            Radars.put("KDDC", new double[]{37.761000, -99.969000, -1354365.150000, 405807.390000, 2590.000000});
            Radars.put("KDFX", new double[]{29.273000, -100.281000, -1530130.150000, -488228.490000, 1131.000000});
            Radars.put("KDIX", new double[]{39.947000, -74.411000, 792760.010000, 569380.390000, 149.000000});
            Radars.put("KDLH", new double[]{46.837000, -92.210000, -616953.770000, 1303773.960000, 1428.000000});
            Radars.put("KDMX", new double[]{41.731000, -93.723000, -784897.210000, 761762.940000, 981.000000});
            Radars.put("KDOX", new double[]{38.826000, -75.440000, 718352.270000, 441507.990000, 50.000000});
            Radars.put("KDTX", new double[]{42.700000, -83.472000, 42131.920000, 827895.360000, 1072.000000});
            Radars.put("KDVN", new double[]{41.612000, -90.581000, -532578.350000, 727990.540000, 754.000000});
            Radars.put("KDYX", new double[]{32.538000, -99.254000, -1380408.330000, -157037.530000, 1517.000000});
            Radars.put("KEAX", new double[]{38.810000, -94.264000, -861056.950000, 453430.770000, 995.000000});
            Radars.put("KEMX", new double[]{31.894000, -110.630000, -2408666.590000, -6096.980000, 5202.000000});
            Radars.put("KENX", new double[]{42.586000, -74.064000, 792750.690000, 855386.310000, 1826.000000});
            Radars.put("KEOX", new double[]{31.461000, -85.459000, -134262.430000, -378493.860000, 434.000000});
            Radars.put("KEPZ", new double[]{31.873000, -106.698000, -2060385.650000, -97308.530000, 4104.000000});
            Radars.put("KESX", new double[]{35.701000, -114.891000, -2656655.430000, 494276.330000, 4867.000000});
            Radars.put("KEVX", new double[]{30.564000, -85.921000, -178647.700000, -474098.430000, 140.000000});
            Radars.put("KEWX", new double[]{29.704000, -98.028000, -1313359.530000, -474831.960000, 633.000000});
            Radars.put("KEYX", new double[]{35.098000, -117.561000, -2899284.660000, 508211.840000, 2757.000000});
            Radars.put("KFCX", new double[]{37.024000, -80.274000, 320301.070000, 222999.600000, 2868.000000});
            Radars.put("KFDR", new double[]{34.362000, -98.976000, -1325890.270000, 32407.310000, 1267.000000});
            Radars.put("KFDX", new double[]{34.635000, -103.630000, -1727356.900000, 133219.790000, 4650.000000});
            Radars.put("KFFC", new double[]{33.364000, -84.566000, -50916.350000, -175198.570000, 858.000000});
            Radars.put("KFSD", new double[]{43.588000, -96.729000, -1000537.070000, 988566.080000, 1430.000000});
            Radars.put("KFSX", new double[]{34.574000, -111.198000, -2380565.510000, 284423.790000, 7417.000000});
            Radars.put("KFTG", new double[]{39.787000, -104.546000, -1692590.030000, 690433.430000, 5497.000000});
            Radars.put("KFWS", new double[]{32.573000, -97.303000, -1204498.060000, -178870.370000, 683.000000});
            Radars.put("KGGW", new double[]{48.206000, -106.625000, -1653088.200000, 1618908.760000, 2276.000000});
            Radars.put("KGJX", new double[]{39.062000, -108.214000, -2008076.140000, 683247.010000, 9992.000000});
            Radars.put("KGLD", new double[]{39.367000, -101.700000, -1468914.640000, 600531.620000, 3651.000000});
            Radars.put("KGRB", new double[]{44.498000, -88.111000, -319826.320000, 1029431.220000, 682.000000});
            Radars.put("KGRK", new double[]{30.722000, -97.383000, -1238555.390000, -374762.490000, 538.000000});
            Radars.put("KGRR", new double[]{42.894000, -85.545000, -122950.700000, 849737.840000, 778.000000});
            Radars.put("KGSP", new double[]{34.883000, -82.220000, 157181.980000, -11121.080000, 940.000000});
            Radars.put("KGWX", new double[]{33.897000, -88.329000, -386801.410000, -109726.490000, 476.000000});
            Radars.put("KGYX", new double[]{43.891000, -70.256000, 1075259.660000, 1031815.380000, 409.000000});
            Radars.put("KHDX", new double[]{33.076000, -106.123000, -1980398.210000, 16650.970000, 4222.000000});
            Radars.put("KHGX", new double[]{29.472000, -95.079000, -1041374.780000, -534781.070000, 18.000000});
            Radars.put("KHNX", new double[]{36.314000, -119.632000, -3024562.790000, 692771.750000, 243.000000});
            Radars.put("KHPX", new double[]{36.737000, -87.285000, -283430.000000, 190895.830000, 576.000000});
            Radars.put("KHTX", new double[]{34.931000, -86.083000, -183826.000000, -5454.680000, 1760.000000});
            Radars.put("KICT", new double[]{37.655000, -97.443000, -1143126.020000, 362600.110000, 1335.000000});
            Radars.put("KICX", new double[]{37.591000, -112.862000, -2428930.570000, 635444.340000, 10600.000000});
            Radars.put("KILN", new double[]{39.420000, -83.822000, 14841.320000, 474181.590000, 1056.000000});
            Radars.put("KILX", new double[]{40.151000, -89.337000, -440523.800000, 564705.140000, 582.000000});
            Radars.put("KIND", new double[]{39.708000, -86.280000, -189370.310000, 507321.570000, 790.000000});
            Radars.put("KINX", new double[]{36.175000, -95.565000, -1002774.310000, 184744.650000, 668.000000});
            Radars.put("KIWA", new double[]{33.289000, -111.670000, -2458907.400000, 163548.350000, 1353.000000});
            Radars.put("KIWX", new double[]{41.359000, -85.700000, -138140.590000, 684123.960000, 960.000000});
            Radars.put("KDGX", new double[]{32.280000, -89.984000, -545026.590000, -275066.040000, 609.000000});
            Radars.put("KJAX", new double[]{30.485000, -81.702000, 213899.510000, -481837.630000, 33.000000});
            Radars.put("KJGX", new double[]{32.675000, -83.351000, 58868.550000, -249029.760000, 521.000000});
            Radars.put("KJKL", new double[]{37.591000, -83.313000, 58647.390000, 277972.950000, 1364.000000});
            Radars.put("KLBB", new double[]{33.654000, -101.814000, -1588258.570000, -542.050000, 3259.000000});
            Radars.put("KLCH", new double[]{30.125000, -93.216000, -860271.990000, -482840.130000, 13.000000});
            Radars.put("KLIX", new double[]{30.337000, -89.826000, -542960.940000, -484208.050000, 24.000000});
            Radars.put("KLNX", new double[]{41.958000, -100.576000, -1329890.150000, 859513.690000, 2970.000000});
            Radars.put("KLOT", new double[]{41.605000, -88.085000, -330767.290000, 716319.520000, 663.000000});
            Radars.put("KLRX", new double[]{40.740000, -116.803000, -2638644.980000, 1058754.290000, 6744.000000});
            Radars.put("KLSX", new double[]{38.699000, -90.683000, -562032.640000, 415732.630000, 608.000000});
            Radars.put("KLTX", new double[]{33.989000, -78.429000, 497114.640000, -94316.650000, 64.000000});
            Radars.put("KLVX", new double[]{37.975000, -85.944000, -165133.330000, 320597.990000, 719.000000});
            Radars.put("KLWX", new double[]{38.975000, -77.478000, 546555.120000, 444409.380000, 272.000000});
            Radars.put("KLZK", new double[]{34.836000, -92.262000, -729180.580000, 12960.740000, 568.000000});
            Radars.put("KMAF", new double[]{31.943000, -102.189000, -1654940.510000, -174832.260000, 2868.000000});
            Radars.put("KMAX", new double[]{42.081000, -122.717000, -3036410.590000, 1364146.540000, 7513.000000});
            Radars.put("KMBX", new double[]{48.393000, -100.865000, -1233545.570000, 1554883.770000, 1493.000000});
            Radars.put("KMHX", new double[]{34.776000, -76.876000, 629396.060000, -1281.750000, 31.000000});
            Radars.put("KMKX", new double[]{42.968000, -88.551000, -361684.660000, 865125.580000, 958.000000});
            Radars.put("KMLB", new double[]{28.113000, -80.654000, 320073.590000, -734323.130000, 35.000000});
            Radars.put("KMOB", new double[]{30.679000, -88.240000, -393681.210000, -455021.510000, 208.000000});
            Radars.put("KMPX", new double[]{44.849000, -93.566000, -739568.120000, 1096821.460000, 946.000000});
            Radars.put("KMQT", new double[]{46.531000, -87.548000, -268075.340000, 1249391.840000, 1411.000000});
            Radars.put("KMRX", new double[]{36.169000, -83.402000, 51973.600000, 125444.550000, 1337.000000});
            Radars.put("KMSX", new double[]{47.041000, -113.986000, -2214712.080000, 1639499.640000, 7855.000000});
            Radars.put("KMTX", new double[]{41.263000, -112.448000, -2282844.520000, 1003854.550000, 0.000000});
            Radars.put("KMUX", new double[]{37.155000, -121.898000, -3173888.400000, 847919.870000, 3469.000000});
            Radars.put("KMVX", new double[]{47.528000, -97.326000, -989305.510000, 1420847.440000, 986.000000});
            Radars.put("KMXX", new double[]{32.537000, -85.790000, -162625.410000, -262549.660000, 400.000000});
            Radars.put("KNKX", new double[]{32.919000, -117.042000, -2932884.600000, 272486.320000, 955.000000});
            Radars.put("KNQA", new double[]{35.345000, -89.873000, -515390.110000, 52310.370000, 282.000000});
            Radars.put("KOAX", new double[]{41.320000, -96.367000, -1002880.040000, 741638.040000, 1148.000000});
            Radars.put("KOHX", new double[]{36.247000, -86.563000, -222515.670000, 136537.260000, 579.000000});
            Radars.put("KOKX", new double[]{40.866000, -72.864000, 909011.770000, 681119.800000, 85.000000});
            Radars.put("KOTX", new double[]{47.680000, -117.627000, -2450281.750000, 1792153.490000, 2384.000000});
            Radars.put("KPAH", new double[]{37.068000, -88.772000, -409928.770000, 231583.110000, 392.000000});
            Radars.put("KPBZ", new double[]{40.532000, -80.218000, 310676.370000, 599760.920000, 1185.000000});
            Radars.put("KPDT", new double[]{45.691000, -118.853000, -2611309.530000, 1618624.930000, 1515.000000});
            Radars.put("KPOE", new double[]{31.156000, -92.976000, -827869.980000, -374567.590000, 408.000000});
            Radars.put("KPUX", new double[]{38.459000, -104.181000, -1691919.880000, 544496.810000, 5249.000000});
            Radars.put("KRAX", new double[]{35.666000, -78.490000, 481649.480000, 84821.840000, 348.000000});
            Radars.put("KRGX", new double[]{39.754000, -119.462000, -2880932.280000, 1033249.250000, 8299.000000});
            Radars.put("KRIW", new double[]{43.066000, -108.477000, -1923478.170000, 1107123.350000, 5568.000000});
            Radars.put("KRLX", new double[]{38.311000, -81.723000, 192583.500000, 357257.880000, 1080.000000});
            Radars.put("KRMX", new double[]{43.468000, -75.458000, 673575.620000, 940114.970000, 1516.000000});
            Radars.put("KRTX", new double[]{45.715000, -122.965000, -2903124.010000, 1735947.050000, 1572.000000});
            Radars.put("KSFX", new double[]{43.106000, -112.686000, -2244338.280000, 1200177.130000, 4474.000000});
            Radars.put("KSGF", new double[]{37.235000, -93.401000, -804963.920000, 277945.280000, 1278.000000});
            Radars.put("KSHV", new double[]{32.451000, -93.841000, -893562.900000, -228666.630000, 273.000000});
            Radars.put("KSJT", new double[]{31.371000, -100.493000, -1512354.290000, -262499.720000, 1890.000000});
            Radars.put("KSOX", new double[]{33.818000, -117.636000, -2951359.740000, 381125.760000, 3027.000000});
            Radars.put("KSRX", new double[]{35.291000, -94.362000, -908798.990000, 78932.750000, 640.000000});
            Radars.put("KTBW", new double[]{27.706000, -82.402000, 153596.310000, -782442.670000, 41.000000});
            Radars.put("KTFX", new double[]{47.460000, -111.385000, -2015203.260000, 1627850.940000, 3714.000000});
            Radars.put("KTLH", new double[]{30.398000, -84.329000, -30657.440000, -493628.270000, 63.000000});
            Radars.put("KTLX", new double[]{35.333000, -97.278000, -1162569.170000, 114001.550000, 1213.000000});
            Radars.put("KTWX", new double[]{38.997000, -96.233000, -1022976.850000, 492182.690000, 1367.000000});
            Radars.put("KTYX", new double[]{43.756000, -75.680000, 653482.400000, 969741.070000, 1846.000000});
            Radars.put("KUDX", new double[]{44.125000, -102.830000, -1464167.690000, 1122324.120000, 3016.000000});
            Radars.put("KUEX", new double[]{40.321000, -98.442000, -1185726.250000, 657991.210000, 1976.000000});
            Radars.put("KVAX", new double[]{30.890000, -83.002000, 92461.350000, -440340.600000, 178.000000});
            Radars.put("KVBX", new double[]{34.838000, -120.397000, -3143581.500000, 568896.770000, 1233.000000});
            Radars.put("KVNX", new double[]{36.741000, -98.128000, -1214969.770000, 273709.390000, 1210.000000});
            Radars.put("KVTX", new double[]{34.412000, -119.179000, -3058888.010000, 487940.960000, 2726.000000});
            Radars.put("KVWX", new double[]{38.266600, -87.716600, -314474.640000, 356191.370000, 392.000000});
            Radars.put("KYUX", new double[]{32.495000, -114.657000, -2742215.430000, 160789.640000, 174.000000});
            Radars.put("LPLA", new double[]{38.730000, -27.322000, 4510528.670000, 1731855.550000, 3334.000000});
            Radars.put("PABC", new double[]{60.792000, -161.876000, -4137893.050000, 4595614.390000, 162.000000});
            Radars.put("PACG", new double[]{56.853000, -135.529000, -3140584.930000, 3244840.620000, 270.000000});
            Radars.put("PAEC", new double[]{64.511000, -165.295000, -3940826.980000, 5053425.530000, 54.000000});
            Radars.put("PAHG", new double[]{60.726000, -151.351000, -3682172.920000, 4172361.660000, 242.000000});
            Radars.put("PAIH", new double[]{59.461000, -146.303000, -3535284.020000, 3867501.110000, 67.000000});
            Radars.put("PAKC", new double[]{58.679000, -156.629000, -4083350.620000, 4194256.520000, 63.000000});
            Radars.put("PAPD", new double[]{65.035000, -147.502000, -3182624.750000, 4459157.330000, 2593.000000});
            Radars.put("PGUA", new double[]{13.454000, 144.808000, -10743955.540000, 6055945.750000, 264.000000});
            Radars.put("PHKI", new double[]{21.894000, -159.552000, -7011835.270000, 1406494.130000, 179.000000});
            Radars.put("PHKM", new double[]{20.126000, -155.778000, -6857333.310000, 998183.040000, 3812.000000});
            Radars.put("PHMO", new double[]{21.133000, -157.180000, -6891003.660000, 1178361.220000, 1363.000000});
            Radars.put("PHWA", new double[]{19.095000, -155.569000, -6916826.160000, 898110.510000, 1370.000000});
            Radars.put("RKJK", new double[]{35.924000, 126.622000, -8590696.710000, 8210291.310000, 78.000000});
            Radars.put("RKSG", new double[]{36.956000, 127.021000, -8478205.120000, 8182361.090000, 52.000000});
            Radars.put("RODN", new double[]{26.302000, 127.910000, -9615542.820000, 8025415.240000, 218.000000});
            Radars.put("TJUA", new double[]{18.116000, -66.078000, 1903018.010000, -1661338.570000, 2794.000000});
            Radars.put("KJAN", new double[]{32.318000, -90.080000, -553508.400000, -270462.850000, 297.000000});
            Radars.put("KOUN", new double[]{35.236058, -97.462350, -1180023.200000, 105895.290000, 1214.000000});
            Radars.put("KLGX", new double[]{47.115800, -124.106900, -2922938.190000, 1910840.560000, 366.000000});

        }
    }

    public Radar(String radarName) {
        this();
        this.radarName = radarName;
    }

    @Override
    public Point2D getXYCoordinates() {
        return new Point2D.Double(Radars.get(radarName)[2], Radars.get(radarName)[3]);
    }

    @Override
    public LatLonPoint getLatLon() {
        return new LatLonPoint.Double(Radars.get(radarName)[0], Radars.get(radarName)[1]);
    }

    @Override
    public double getRadarHeight() {
        return Radars.get(radarName)[4];
    }

    /*
    Use static subclasses to describe all radars. Might be more logical. KABR is a sample.
     */
    public static class KABR extends Radar {
        public KABR() {
            super("KABR");
        }
    }

    public static class KABX extends Radar {
        public KABX() {
            super("KABX");
        }
    }

    public static class KAKQ extends Radar {
        public KAKQ() {
            super("KAKQ");
        }
    }

    public static class KAMA extends Radar {
        public KAMA() {
            super("KAMA");
        }
    }

    public static class KAMX extends Radar {
        public KAMX() {
            super("KAMX");
        }
    }

    public static class KAPX extends Radar {
        public KAPX() {
            super("KAPX");
        }
    }

    public static class KARX extends Radar {
        public KARX() {
            super("KARX");
        }
    }

    public static class KATX extends Radar {
        public KATX() {
            super("KATX");
        }
    }

    public static class KBBX extends Radar {
        public KBBX() {
            super("KBBX");
        }
    }

    public static class KBGM extends Radar {
        public KBGM() {
            super("KBGM");
        }
    }

    public static class KBHX extends Radar {
        public KBHX() {
            super("KBHX");
        }
    }

    public static class KBIS extends Radar {
        public KBIS() {
            super("KBIS");
        }
    }

    public static class KBIX extends Radar {
        public KBIX() {
            super("KBIX");
        }
    }

    public static class KBLX extends Radar {
        public KBLX() {
            super("KBLX");
        }
    }

    public static class KBMX extends Radar {
        public KBMX() {
            super("KBMX");
        }
    }

    public static class KBOX extends Radar {
        public KBOX() {
            super("KBOX");
        }
    }

    public static class KBRO extends Radar {
        public KBRO() {
            super("KBRO");
        }
    }

    public static class KBUF extends Radar {
        public KBUF() {
            super("KBUF");
        }
    }

    public static class KBYX extends Radar {
        public KBYX() {
            super("KBYX");
        }
    }

    public static class KCAE extends Radar {
        public KCAE() {
            super("KCAE");
        }
    }

    public static class KCBW extends Radar {
        public KCBW() {
            super("KCBW");
        }
    }

    public static class KCBX extends Radar {
        public KCBX() {
            super("KCBX");
        }
    }

    public static class KCCX extends Radar {
        public KCCX() {
            super("KCCX");
        }
    }

    public static class KCLE extends Radar {
        public KCLE() {
            super("KCLE");
        }
    }

    public static class KCLX extends Radar {
        public KCLX() {
            super("KCLX");
        }
    }

    public static class KCRI extends Radar {
        public KCRI() {
            super("KCRI");
        }
    }

    public static class KCRP extends Radar {
        public KCRP() {
            super("KCRP");
        }
    }

    public static class KCXX extends Radar {
        public KCXX() {
            super("KCXX");
        }
    }

    public static class KCYS extends Radar {
        public KCYS() {
            super("KCYS");
        }
    }

    public static class KDAX extends Radar {
        public KDAX() {
            super("KDAX");
        }
    }

    public static class KDDC extends Radar {
        public KDDC() {
            super("KDDC");
        }
    }

    public static class KDFX extends Radar {
        public KDFX() {
            super("KDFX");
        }
    }

    public static class KDIX extends Radar {
        public KDIX() {
            super("KDIX");
        }
    }

    public static class KDLH extends Radar {
        public KDLH() {
            super("KDLH");
        }
    }

    public static class KDMX extends Radar {
        public KDMX() {
            super("KDMX");
        }
    }

    public static class KDOX extends Radar {
        public KDOX() {
            super("KDOX");
        }
    }

    public static class KDTX extends Radar {
        public KDTX() {
            super("KDTX");
        }
    }

    public static class KDVN extends Radar {
        public KDVN() {
            super("KDVN");
        }
    }

    public static class KDYX extends Radar {
        public KDYX() {
            super("KDYX");
        }
    }

    public static class KEAX extends Radar {
        public KEAX() {
            super("KEAX");
        }
    }

    public static class KEMX extends Radar {
        public KEMX() {
            super("KEMX");
        }
    }

    public static class KENX extends Radar {
        public KENX() {
            super("KENX");
        }
    }

    public static class KEOX extends Radar {
        public KEOX() {
            super("KEOX");
        }
    }

    public static class KEPZ extends Radar {
        public KEPZ() {
            super("KEPZ");
        }
    }

    public static class KESX extends Radar {
        public KESX() {
            super("KESX");
        }
    }

    public static class KEVX extends Radar {
        public KEVX() {
            super("KEVX");
        }
    }

    public static class KEWX extends Radar {
        public KEWX() {
            super("KEWX");
        }
    }

    public static class KEYX extends Radar {
        public KEYX() {
            super("KEYX");
        }
    }

    public static class KFCX extends Radar {
        public KFCX() {
            super("KFCX");
        }
    }

    public static class KFDR extends Radar {
        public KFDR() {
            super("KFDR");
        }
    }

    public static class KFDX extends Radar {
        public KFDX() {
            super("KFDX");
        }
    }

    public static class KFFC extends Radar {
        public KFFC() {
            super("KFFC");
        }
    }

    public static class KFSD extends Radar {
        public KFSD() {
            super("KFSD");
        }
    }

    public static class KFSX extends Radar {
        public KFSX() {
            super("KFSX");
        }
    }

    public static class KFTG extends Radar {
        public KFTG() {
            super("KFTG");
        }
    }

    public static class KFWS extends Radar {
        public KFWS() {
            super("KFWS");
        }
    }

    public static class KGGW extends Radar {
        public KGGW() {
            super("KGGW");
        }
    }

    public static class KGJX extends Radar {
        public KGJX() {
            super("KGJX");
        }
    }

    public static class KGLD extends Radar {
        public KGLD() {
            super("KGLD");
        }
    }

    public static class KGRB extends Radar {
        public KGRB() {
            super("KGRB");
        }
    }

    public static class KGRK extends Radar {
        public KGRK() {
            super("KGRK");
        }
    }

    public static class KGRR extends Radar {
        public KGRR() {
            super("KGRR");
        }
    }

    public static class KGSP extends Radar {
        public KGSP() {
            super("KGSP");
        }
    }

    public static class KGWX extends Radar {
        public KGWX() {
            super("KGWX");
        }
    }

    public static class KGYX extends Radar {
        public KGYX() {
            super("KGYX");
        }
    }

    public static class KHDX extends Radar {
        public KHDX() {
            super("KHDX");
        }
    }

    public static class KHGX extends Radar {
        public KHGX() {
            super("KHGX");
        }
    }

    public static class KHNX extends Radar {
        public KHNX() {
            super("KHNX");
        }
    }

    public static class KHPX extends Radar {
        public KHPX() {
            super("KHPX");
        }
    }

    public static class KHTX extends Radar {
        public KHTX() {
            super("KHTX");
        }
    }

    public static class KICT extends Radar {
        public KICT() {
            super("KICT");
        }
    }

    public static class KICX extends Radar {
        public KICX() {
            super("KICX");
        }
    }

    public static class KILN extends Radar {
        public KILN() {
            super("KILN");
        }
    }

    public static class KILX extends Radar {
        public KILX() {
            super("KILX");
        }
    }

    public static class KIND extends Radar {
        public KIND() {
            super("KIND");
        }
    }

    public static class KINX extends Radar {
        public KINX() {
            super("KINX");
        }
    }

    public static class KIWA extends Radar {
        public KIWA() {
            super("KIWA");
        }
    }

    public static class KIWX extends Radar {
        public KIWX() {
            super("KIWX");
        }
    }

    public static class KDGX extends Radar {
        public KDGX() {
            super("KDGX");
        }
    }

    public static class KJAX extends Radar {
        public KJAX() {
            super("KJAX");
        }
    }

    public static class KJGX extends Radar {
        public KJGX() {
            super("KJGX");
        }
    }

    public static class KJKL extends Radar {
        public KJKL() {
            super("KJKL");
        }
    }

    public static class KLBB extends Radar {
        public KLBB() {
            super("KLBB");
        }
    }

    public static class KLCH extends Radar {
        public KLCH() {
            super("KLCH");
        }
    }

    public static class KLIX extends Radar {
        public KLIX() {
            super("KLIX");
        }
    }

    public static class KLNX extends Radar {
        public KLNX() {
            super("KLNX");
        }
    }

    public static class KLOT extends Radar {
        public KLOT() {
            super("KLOT");
        }
    }

    public static class KLRX extends Radar {
        public KLRX() {
            super("KLRX");
        }
    }

    public static class KLSX extends Radar {
        public KLSX() {
            super("KLSX");
        }
    }

    public static class KLTX extends Radar {
        public KLTX() {
            super("KLTX");
        }
    }

    public static class KLVX extends Radar {
        public KLVX() {
            super("KLVX");
        }
    }

    public static class KLWX extends Radar {
        public KLWX() {
            super("KLWX");
        }
    }

    public static class KLZK extends Radar {
        public KLZK() {
            super("KLZK");
        }
    }

    public static class KMAF extends Radar {
        public KMAF() {
            super("KMAF");
        }
    }

    public static class KMAX extends Radar {
        public KMAX() {
            super("KMAX");
        }
    }

    public static class KMBX extends Radar {
        public KMBX() {
            super("KMBX");
        }
    }

    public static class KMHX extends Radar {
        public KMHX() {
            super("KMHX");
        }
    }

    public static class KMKX extends Radar {
        public KMKX() {
            super("KMKX");
        }
    }

    public static class KMLB extends Radar {
        public KMLB() {
            super("KMLB");
        }
    }

    public static class KMOB extends Radar {
        public KMOB() {
            super("KMOB");
        }
    }

    public static class KMPX extends Radar {
        public KMPX() {
            super("KMPX");
        }
    }

    public static class KMQT extends Radar {
        public KMQT() {
            super("KMQT");
        }
    }

    public static class KMRX extends Radar {
        public KMRX() {
            super("KMRX");
        }
    }

    public static class KMSX extends Radar {
        public KMSX() {
            super("KMSX");
        }
    }

    public static class KMTX extends Radar {
        public KMTX() {
            super("KMTX");
        }
    }

    public static class KMUX extends Radar {
        public KMUX() {
            super("KMUX");
        }
    }

    public static class KMVX extends Radar {
        public KMVX() {
            super("KMVX");
        }
    }

    public static class KMXX extends Radar {
        public KMXX() {
            super("KMXX");
        }
    }

    public static class KNKX extends Radar {
        public KNKX() {
            super("KNKX");
        }
    }

    public static class KNQA extends Radar {
        public KNQA() {
            super("KNQA");
        }
    }

    public static class KOAX extends Radar {
        public KOAX() {
            super("KOAX");
        }
    }

    public static class KOHX extends Radar {
        public KOHX() {
            super("KOHX");
        }
    }

    public static class KOKX extends Radar {
        public KOKX() {
            super("KOKX");
        }
    }

    public static class KOTX extends Radar {
        public KOTX() {
            super("KOTX");
        }
    }

    public static class KPAH extends Radar {
        public KPAH() {
            super("KPAH");
        }
    }

    public static class KPBZ extends Radar {
        public KPBZ() {
            super("KPBZ");
        }
    }

    public static class KPDT extends Radar {
        public KPDT() {
            super("KPDT");
        }
    }

    public static class KPOE extends Radar {
        public KPOE() {
            super("KPOE");
        }
    }

    public static class KPUX extends Radar {
        public KPUX() {
            super("KPUX");
        }
    }

    public static class KRAX extends Radar {
        public KRAX() {
            super("KRAX");
        }
    }

    public static class KRGX extends Radar {
        public KRGX() {
            super("KRGX");
        }
    }

    public static class KRIW extends Radar {
        public KRIW() {
            super("KRIW");
        }
    }

    public static class KRLX extends Radar {
        public KRLX() {
            super("KRLX");
        }
    }

    public static class KRMX extends Radar {
        public KRMX() {
            super("KRMX");
        }
    }

    public static class KRTX extends Radar {
        public KRTX() {
            super("KRTX");
        }
    }

    public static class KSFX extends Radar {
        public KSFX() {
            super("KSFX");
        }
    }

    public static class KSGF extends Radar {
        public KSGF() {
            super("KSGF");
        }
    }

    public static class KSHV extends Radar {
        public KSHV() {
            super("KSHV");
        }
    }

    public static class KSJT extends Radar {
        public KSJT() {
            super("KSJT");
        }
    }

    public static class KSOX extends Radar {
        public KSOX() {
            super("KSOX");
        }
    }

    public static class KSRX extends Radar {
        public KSRX() {
            super("KSRX");
        }
    }

    public static class KTBW extends Radar {
        public KTBW() {
            super("KTBW");
        }
    }

    public static class KTFX extends Radar {
        public KTFX() {
            super("KTFX");
        }
    }

    public static class KTLH extends Radar {
        public KTLH() {
            super("KTLH");
        }
    }

    public static class KTLX extends Radar {
        public KTLX() {
            super("KTLX");
        }
    }

    public static class KTWX extends Radar {
        public KTWX() {
            super("KTWX");
        }
    }

    public static class KTYX extends Radar {
        public KTYX() {
            super("KTYX");
        }
    }

    public static class KUDX extends Radar {
        public KUDX() {
            super("KUDX");
        }
    }

    public static class KUEX extends Radar {
        public KUEX() {
            super("KUEX");
        }
    }

    public static class KVAX extends Radar {
        public KVAX() {
            super("KVAX");
        }
    }

    public static class KVBX extends Radar {
        public KVBX() {
            super("KVBX");
        }
    }

    public static class KVNX extends Radar {
        public KVNX() {
            super("KVNX");
        }
    }

    public static class KVTX extends Radar {
        public KVTX() {
            super("KVTX");
        }
    }

    public static class KVWX extends Radar {
        public KVWX() {
            super("KVWX");
        }
    }

    public static class KYUX extends Radar {
        public KYUX() {
            super("KYUX");
        }
    }

    public static class LPLA extends Radar {
        public LPLA() {
            super("LPLA");
        }
    }

    public static class PABC extends Radar {
        public PABC() {
            super("PABC");
        }
    }

    public static class PACG extends Radar {
        public PACG() {
            super("PACG");
        }
    }

    public static class PAEC extends Radar {
        public PAEC() {
            super("PAEC");
        }
    }

    public static class PAHG extends Radar {
        public PAHG() {
            super("PAHG");
        }
    }

    public static class PAIH extends Radar {
        public PAIH() {
            super("PAIH");
        }
    }

    public static class PAKC extends Radar {
        public PAKC() {
            super("PAKC");
        }
    }

    public static class PAPD extends Radar {
        public PAPD() {
            super("PAPD");
        }
    }

    public static class PGUA extends Radar {
        public PGUA() {
            super("PGUA");
        }
    }

    public static class PHKI extends Radar {
        public PHKI() {
            super("PHKI");
        }
    }

    public static class PHKM extends Radar {
        public PHKM() {
            super("PHKM");
        }
    }

    public static class PHMO extends Radar {
        public PHMO() {
            super("PHMO");
        }
    }

    public static class PHWA extends Radar {
        public PHWA() {
            super("PHWA");
        }
    }

    public static class RKJK extends Radar {
        public RKJK() {
            super("RKJK");
        }
    }

    public static class RKSG extends Radar {
        public RKSG() {
            super("RKSG");
        }
    }

    public static class RODN extends Radar {
        public RODN() {
            super("RODN");
        }
    }

    public static class TJUA extends Radar {
        public TJUA() {
            super("TJUA");
        }
    }

    public static class KJAN extends Radar {
        public KJAN() {
            super("KJAN");
        }
    }

    public static class KOUN extends Radar {
        public KOUN() {
            super("KOUN");
        }
    }

    public static class KLGX extends Radar {
        public KLGX() {
            super("KLGX");
        }
    }
}
