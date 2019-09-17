package prac_8;

import sun.security.acl.PermissionImpl;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Java8 ������ȫ�µ�Stream API��
 * ��������������ͬ���������Ϊ����Iterable�ļ����ࡣ
 * ����Ϊ�ͼ�������������ͬ��
 *
 * Stream�ǶԼ��϶����ܵ���ǿ����רע�ڶԼ��϶�����и��� �ǳ����㡢��Ч �ľۺϲ��������ߴ��������ݲ�����
 * Stream�Ǻ���ʽ��̵����֡������ر����ҵ���߼�����ͼ������ʵ�ֻ��ơ�
 * �׶��Ĵ���Ҳ����ά�������ɿ����������׳���
 *
 * filter����һ��������Ϊ�������ú�����Lambda���ʽ����param-list��->expression����ʾ�����磺(a,b) => a+b��
 *
 * map���ɵ���һ��һӳ�䣬for�����á�
 *
 * FlatMap����Map��࣬�����εĲ�����
 * Map��һ��һ��ÿ������Ԫ�أ������չ���ת����Ϊ����һ��Ԫ�ء�����Ƕ��list����������Ƕ��list��
 * FlatMap��һ�Զࡣ����Ƕ��list�������������һ��list��
 * ͨ�׵�˵���������Ƕ�����ôflatMap���Բ�����������Ķ��󣬶�mapֻ�ܲ�����һ�㡣
 *
 * Reduce ���Ƶݹ顣
 *
 * collect �����������б�map���ȳ��õ����ݽṹ��
 * toList(),toSet(),toMap(),�Զ��塣
 *
 * Optional��Ϊ�����������Ƶ�һ���������ͣ������滻nullֵ��
 * ���null�����ֵ���ǵĴ���
 */
public class StreamTest{
    /**
     * ʹ��filter��ȡ�������Գ�Ա��
     */
    // old method.
    public static List<PersonModel> filterSexOld(List<PersonModel> data){
        List<PersonModel> temp = new ArrayList<>();
        for(PersonModel person:data){
            if(Sex.m.equals(person.getSex())){
                temp.add(person);
            }
        }
        return temp;
    }
    // new method.
    public static List<PersonModel> filterSexNew(List<PersonModel> data){
        List<PersonModel> collect = data.
                                    stream()
                                    .filter(person -> Sex.m.equals(person.getSex()))
                                    .collect(toList());
        return collect;
    }
    /**
     * ʹ��map��ȡ���г�Ա������
     */
    public static void getUserNameList(){
        List<PersonModel> data = Data.getData();

        // old
        List<String> list = new ArrayList<>();
        for(PersonModel person:data){
            list.add(person.getName());
        }
        System.out.println(list);

        //new 1
        List<String> collect1 = data
                              .stream()
                              .map(person -> person.getName())
                              .collect(toList());
        System.out.println(collect1);

        //new 2
        List<String> collect2 = data.stream().map(PersonModel::getName).collect(toList());
        System.out.println(collect2);

        //new 3
        List<String> collect3 = data.stream()
                                    .map(person -> {System.out.println(person.getName());return person.getName();})
                                    .collect(toList());
        System.out.println(collect3);
    }
    /**
     * FlatMapӦ�á�
     */
    public static void flatMapString(){
        List<PersonModel> data = Data.getData();
        // �������Ͳ�һ����
        List<String> collect = data.stream()
                .flatMap(person -> Arrays.stream(person.getName().split(" "))).collect(toList());

        //��mapʵ�֡�
        List<String> collect2 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream).collect(toList());

        // ��һ�ַ�ʽ
        List<String> collect3 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(toList());
    }

    /**
     * ReduceӦ�á�
     */
    public static void reduceTest(){
        // �ۼӣ���ʼֵ��10.
        Integer reduce = Stream.of(1,2,3,4)
                .reduce(10,(count,item) ->{
                   System.out.println("count:"+count);
                   System.out.println("item:"+item);
                   return count + item;
                });
        System.out.println(reduce);

        Integer reduce1 = Stream.of(1,2,3,4)
                .reduce(0,(x,y) -> x+y);
        System.out.println(reduce1);

        String reduce2 = Stream.of("1","2","3","4")
                .reduce("0",(x,y) -> (x+"."+y));
        System.out.println(reduce2);

    }

    /**
     * Collect���ԡ�
     */
    // toList
    public static void toListTest(){
        List<PersonModel> data = Data.getData();
        List<String> collect = data.stream()
                .map(PersonModel::getName)
                .collect(toList());
    }
    // toSet
    public static void toSetTest(){
        List<PersonModel> data = Data.getData();
        Set<String> collect = data.stream()
                .map(PersonModel::getName)
                .collect(toSet());
    }
    // toMap
    public static void toMapTest(){
        List<PersonModel> data = Data.getData();
        Map<String,Integer> collect = data.stream().collect(toMap(PersonModel::getName,PersonModel::getAge));
        Map<String,String> collect2 = data.stream().collect(toMap(per -> per.getName(),value->{return value+"1";}));
    }
    // ָ������
    public static void toTreeSetTest(){
        List<PersonModel> data = Data.getData();
        TreeSet<PersonModel> collect = data.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }
    // ����
    public static void toGroupTest(){
        List<PersonModel> data = Data.getData();
        Map<Boolean,List<PersonModel>> collect = data.stream()
                .collect(Collectors.groupingBy(per -> Sex.m.equals(per.getSex())));//{false=[prac_8.PersonModel@65ab7765, prac_8.PersonModel@1b28cdfa], true=[prac_8.PersonModel@4554617c, prac_8.PersonModel@74a14482, prac_8.PersonModel@1540e19d, prac_8.PersonModel@677327b6]}
        System.out.println(collect);
    }
    // �ָ�
    public static void toJoiningTest(){
        List<PersonModel> data = Data.getData();
        String collect = data.stream()
                .map(personModel -> personModel.getName())
                .collect(Collectors.joining(",","{","}"));//{sam,tom,kitty,harry potter,ti mi,frank}
        System.out.println(collect);
    }
    // �Զ���
    public static void reduce(){
        List<String> collect = Stream.of("1","2","3","4").collect(
                Collectors.reducing(new ArrayList<String>(),x->Arrays.asList(x+0),(y,z)->{
                    y.addAll(z);
                    return y;
                }));
        System.out.println(collect);
    }
    public static void testOptional() throws RuntimeException{
        //���Ϊ�գ������׳��쳣��
        //System.out.println(Optional.ofNullable("1").orElseThrow(()->{throw new RuntimeException("ss");}));
        //Error:(188, 64) java: δ������쳣����java.lang.Throwable; ���������в���������Ա��׳�
    }

    public static void testOption2(){
        PersonModel personModel = new PersonModel();
        Optional.ofNullable(personModel)
                .map(PersonModel::getName)
                //.map(PersonModel::getSex)//������˼�ͺã�
                //.map(PersonModel::getAge)//Error:(188, 64) java: δ������쳣����java.lang.Throwable; ���������в���������Ա��׳�
                .isPresent();

        List<PersonModel> models = Data.getData();
        Optional.ofNullable(models).map(per -> per.stream().map(PersonModel::getName).collect(toList())).ifPresent(per->System.out.println(per));
    }
    public static void main(String args[]){
        List<PersonModel> data = Data.getData();
        List<PersonModel> resultOld = filterSexOld(data);
        System.out.println(resultOld);

        List<PersonModel> resultNew = filterSexNew(data);
        System.out.println(resultNew);

        getUserNameList();

        reduceTest();

        toGroupTest();

        toJoiningTest();

        reduce();

        /**
         * Optional����
         */
        PersonModel personModel = new PersonModel();
        //����Ϊ�����ӡ-
        Optional<Object> o = Optional.of(personModel);
        System.out.println(o.isPresent()?o.get():"-");

        //����Ϊ�����ӡ-
        Optional<String> name = Optional.ofNullable(personModel.getName());
        System.out.println(name.isPresent()?name.get():"-");

        //�����Ϊ�գ����ӡ
        Optional.ofNullable(null).ifPresent(na ->{System.out.println(na+"ifPresent");});
        Optional.ofNullable("test").ifPresent(na ->{System.out.println(na+"ifPresent");});

        //���Ϊ�գ��򷵻�ָ���ַ�����
        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

        //���Ϊ�գ��򷵻�ָ�����������ߴ��롣
        System.out.println(Optional.ofNullable(null).orElseGet(()->{return "hahaha";}));
        System.out.println(Optional.ofNullable("1").orElseGet(()->{return "hahaha";}));
        try{
            testOptional();
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        // Optional�༶�б�
        testOption2();

        //������stream�滻��parallelStream����parallel

        // list.map.filter.map.** Ϊ��ʽ���ã����յ���collect()���ؽ����

        // ����ֵΪStream���Ƕ�����ֵ������ֵΪ��һ��ֵ��Ϊ�գ���Ϊ������ֵ��
        // ����״̬Ϊ��ʹ�����������γ�һ��������ֵ�����������һ��������ֵ�Ĳ���������Ҫ�Ľ����
        // ͨ��peek�ܲ鿴ÿ��ֵ��ͬʱ�ܼ�����������map(...).peek(System.out.println(p)).collect(...);
    }
}
