package IThub.kotlin.KotlinFromScratch.MyFirstKotlinScratch.app.base

/**
 * @author yyx
 */

interface IBasePresenter<V : IBaseView> {
    fun subscribe()

    fun unsubscribe()

    fun attachView(view: V)

    fun detachView()

}
