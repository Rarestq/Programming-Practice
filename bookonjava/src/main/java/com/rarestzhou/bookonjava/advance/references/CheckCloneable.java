package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/15 3:24 PM
 * @description: 检查一个引用是否可以克隆
 */
public class CheckCloneable {

    public static Ordinary tryToClone(Ordinary ord) {
        String id = ord.getClass().getName();
        System.out.println("Attempting " + id);
        Ordinary x = null;
        if (ord instanceof Cloneable) {
            try {
                x = (Ordinary) ((IsCloneable) ord).clone();
                System.out.println("Cloned " + id);
            } catch (CloneNotSupportedException e) {
                System.out.println(
                        "Could not clone " + id);
            }
        } else {
            System.out.println("Doesn't implement Cloneable");
        }
        return x;
    }

    public static void main(String[] args) {
        // 向上转型
        Ordinary[] ord = {
                new IsCloneable(),
                new WrongClone(),
                new NoMore(),
                new TryMore(),
                new BackOn(),
                new ReallyNoMore(),
        };
        Ordinary x = new Ordinary();
        // This won't compile because
        // clone() is protected in Object:
        //- x = (Ordinary)x.clone();
        // Checks first to see if the class
        // implements Cloneable:
        for (Ordinary ord1 : ord) {
            tryToClone(ord1);
        }
    }
}

// 无法克隆，未重写 clone();
class Ordinary {
}

// 重写clone(),为实现 Cloneable 接口
class WrongClone extends Ordinary {

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 抛出异常
        return super.clone();
    }
}

// 完美克隆
class IsCloneable extends Ordinary implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 抛出异常
        return super.clone();
    }
}

// 通过抛出异常来关闭克隆
class NoMore extends IsCloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 抛出异常
        throw new CloneNotSupportedException();
    }
}

class TryMore extends NoMore {
    @Override
    public Object clone()
            throws CloneNotSupportedException {
        // Calls NoMore.clone(), throws exception:
        return super.clone();
    }
}

class BackOn extends NoMore {
    private BackOn duplicate(BackOn b) {
        // Somehow make a copy of b and return that
        // copy. A dummy copy, just to make a point:
        return new BackOn();
    }

    @Override
    public Object clone() {
        // Doesn't call NoMore.clone():
        return duplicate(this);
    }
}

// You can't inherit from this, so you can't
// override clone() as you can in BackOn:
final class ReallyNoMore extends NoMore {
}


