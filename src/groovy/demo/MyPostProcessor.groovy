// src/groovy/demo/MyPostProcessor.groovy
package demo

import groovy.transform.CompileStatic
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor

@CompileStatic
class MyPostProcessor implements BeanDefinitionRegistryPostProcessor{

    @Override
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        def definition = registry.getBeanDefinition('authenticationEntryPoint')
        definition.beanClassName = MyEntryPoint.name
    }

    @Override
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
