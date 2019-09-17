package prac_8;

import sun.security.acl.PermissionImpl;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Java8 引入了全新的Stream API。
 * 其和输入输出流不同，可以理解为具有Iterable的集合类。
 * 但行为和集合类又有所不同。
 *
 * Stream是对集合对象功能的增强，其专注于对集合对象进行各种 非常方便、高效 的聚合操作，或者大批量数据操作。
 * Stream是函数式编程的体现。其更多地表达了业务逻辑的意图，而非实现机制。
 * 易读的代码也易于维护、更可靠、更不容易出错。
 *
 * filter接收一个函数作为参数，该函数用Lambda表达式（（param-list）->expression）表示，比如：(a,b) => a+b。
 *
 * map生成的是一对一映射，for的作用。
 *
 * FlatMap，和Map差不多，更深层次的操作。
 * Map是一对一，每个输入元素，都按照规则转换成为另外一个元素。入参是多个list，结果返回是多个list。
 * FlatMap是一对多。入参是多个list，而结果返回是一个list。
 * 通俗的说，如果入参是对象，那么flatMap可以操作对象里面的对象，而map只能操作第一层。
 *
 * Reduce 类似递归。
 *
 * collect 在流中生成列表，map，等常用的数据结构。
 * toList(),toSet(),toMap(),自定义。
 *
 * Optional是为核心类库新设计的一个数据类型，用来替换null值。
 * 针对null这个价值连城的错误。
 */
public class StreamTest{
    /**
     * 使用filter获取所有男性成员。
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
     * 使用map获取所有成员姓名。
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
     * FlatMap应用。
     */
    public static void flatMapString(){
        List<PersonModel> data = Data.getData();
        // 返回类型不一样。
        List<String> collect = data.stream()
                .flatMap(person -> Arrays.stream(person.getName().split(" "))).collect(toList());

        //用map实现。
        List<String> collect2 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream).collect(toList());

        // 另一种方式
        List<String> collect3 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(toList());
    }

    /**
     * Reduce应用。
     */
    public static void reduceTest(){
        // 累加，初始值是10.
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
     * Collect测试。
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
    // 指定类型
    public static void toTreeSetTest(){
        List<PersonModel> data = Data.getData();
        TreeSet<PersonModel> collect = data.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }
    // 分组
    public static void toGroupTest(){
        List<PersonModel> data = Data.getData();
        Map<Boolean,List<PersonModel>> collect = data.stream()
                .collect(Collectors.groupingBy(per -> Sex.m.equals(per.getSex())));//{false=[prac_8.PersonModel@65ab7765, prac_8.PersonModel@1b28cdfa], true=[prac_8.PersonModel@4554617c, prac_8.PersonModel@74a14482, prac_8.PersonModel@1540e19d, prac_8.PersonModel@677327b6]}
        System.out.println(collect);
    }
    // 分隔
    public static void toJoiningTest(){
        List<PersonModel> data = Data.getData();
        String collect = data.stream()
                .map(personModel -> personModel.getName())
                .collect(Collectors.joining(",","{","}"));//{sam,tom,kitty,harry potter,ti mi,frank}
        System.out.println(collect);
    }
    // 自定义
    public static void reduce(){
        List<String> collect = Stream.of("1","2","3","4").collect(
                Collectors.reducing(new ArrayList<String>(),x->Arrays.asList(x+0),(y,z)->{
                    y.addAll(z);
                    return y;
                }));
        System.out.println(collect);
    }
    public static void testOptional() throws RuntimeException{
        //如果为空，可以抛出异常。
        //System.out.println(Optional.ofNullable("1").orElseThrow(()->{throw new RuntimeException("ss");}));
        //Error:(188, 64) java: 未报告的异常错误java.lang.Throwable; 必须对其进行捕获或声明以便抛出
    }

    public static void testOption2(){
        PersonModel personModel = new PersonModel();
        Optional.ofNullable(personModel)
                .map(PersonModel::getName)
                //.map(PersonModel::getSex)//明白意思就好！
                //.map(PersonModel::getAge)//Error:(188, 64) java: 未报告的异常错误java.lang.Throwable; 必须对其进行捕获或声明以便抛出
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
         * Optional测试
         */
        PersonModel personModel = new PersonModel();
        //对象为空则打印-
        Optional<Object> o = Optional.of(personModel);
        System.out.println(o.isPresent()?o.get():"-");

        //名称为空则打印-
        Optional<String> name = Optional.ofNullable(personModel.getName());
        System.out.println(name.isPresent()?name.get():"-");

        //如果不为空，则打印
        Optional.ofNullable(null).ifPresent(na ->{System.out.println(na+"ifPresent");});
        Optional.ofNullable("test").ifPresent(na ->{System.out.println(na+"ifPresent");});

        //如果为空，则返回指定字符串。
        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

        //如果为空，则返回指定方法，或者代码。
        System.out.println(Optional.ofNullable(null).orElseGet(()->{return "hahaha";}));
        System.out.println(Optional.ofNullable("1").orElseGet(()->{return "hahaha";}));
        try{
            testOptional();
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        // Optional多级判别
        testOption2();

        //并发，stream替换成parallelStream或者parallel

        // list.map.filter.map.** 为链式调用，最终调用collect()返回结果。

        // 返回值为Stream则是惰性求值。返回值为另一个值或为空，则为及早求值。
        // 理想状态为：使用上述操作形成一个惰性求值的链，最后用一个及早求值的操作返回想要的结果。
        // 通过peek能查看每个值，同时能继续操作流。map(...).peek(System.out.println(p)).collect(...);
    }
}
