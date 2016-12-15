package kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/22.
 */
public class KryoUtillity {

    /**
     * 获取已注册序列化类的Kryo handle
     *
     * @return
     */
    public static Kryo getKryo() {
        Kryo kryo = new Kryo();

        // 后一位是序列化类的ID，这个ID 保证区分同一个类 不同序列化的情况（猜测）。
//        kryo.register(Gm.class, new GmSerializer(), 0);
//        kryo.register(Mw.class, new MwSerializer(), 1);
//        kryo.register(Mg.class, new MgSerializer(), 2);
//        kryo.register(Mi.class, new MiSerializer(), 3);
//        kryo.register(Mj.class, new MjSerializer(), 4);
//        kryo.register(ISC.class, new ISCSerializer(), 5);
//        //Sv
//        kryo.register(Cx.class, new CxSerializer(), 6);
//        kryo.register(Dx.class, new DxSerializer(), 7);
//        kryo.register(Sh.class, new ShSerializer(), 8);
//        kryo.register(Dh.class, new DhSerializer(), 9);
//        kryo.register(Zh.class, new ZhSerializer(), 10);
//        //Gx
//        kryo.register(Rx.class, new RxSerializer(), 11);
//
//        kryo.register(Nc.class, new NcSerializer(), 12);
//        kryo.register(MergedXDR.class, new MergedXDRSerializer(), 13);
        return kryo;
    }

    /**
     * 序列化输出格式
     *
     * @param kryo   Kryo handle
     * @param object Object
     * @return byte array
     */
    public static byte[] serialize(Kryo kryo, Object object) {
        Output output = new Output(1000, Integer.MAX_VALUE);
        kryo.writeClassAndObject(output, object);
        output.close();
        return output.toBytes();
    }

    /**
     * 反序列化输入格式
     *
     * @param kryo Kryo handle
     * @param data data
     * @param <T>  Object type
     * @return Object
     */
    public static <T> T deserialize(Kryo kryo, byte[] data) {
        return (T) kryo.readClassAndObject(new Input(data));
    }
}
