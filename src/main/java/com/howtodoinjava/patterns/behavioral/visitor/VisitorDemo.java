package com.howtodoinjava.patterns.behavioral.visitor;

interface Router {
    void accept(RouterVisitor visitor);
}

final class OfficeRouter implements Router {
    @Override
    public void accept(RouterVisitor visitor) {
        visitor.visit(this);
    }
}

final class BranchRouter implements Router {
    @Override
    public void accept(RouterVisitor visitor) {
        visitor.visit(this);
    }
}

interface RouterVisitor {
    void visit(OfficeRouter router);
    void visit(BranchRouter router);
}

final class LinuxConfigurator implements RouterVisitor {
    @Override
    public void visit(OfficeRouter router) {
        System.out.println("Linux plan for office router");
    }

    @Override
    public void visit(BranchRouter router) {
        System.out.println("Linux plan for branch router");
    }
}

final class MacConfigurator implements RouterVisitor {
    @Override
    public void visit(OfficeRouter router) {
        System.out.println("Mac plan for office router");
    }

    @Override
    public void visit(BranchRouter router) {
        System.out.println("Mac plan for branch router");
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Router[] routers = {new OfficeRouter(), new BranchRouter()};
        RouterVisitor linux = new LinuxConfigurator();
        RouterVisitor mac = new MacConfigurator();

        for (Router router : routers) {
            router.accept(linux);
            router.accept(mac);
        }
    }
}
