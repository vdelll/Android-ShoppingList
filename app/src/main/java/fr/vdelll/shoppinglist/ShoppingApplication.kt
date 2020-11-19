package fr.vdelll.shoppinglist

import android.app.Application
import fr.vdelll.shoppinglist.data.db.ShoppingDatabase
import fr.vdelll.shoppinglist.data.repositories.ShoppingRepository
import fr.vdelll.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by vdelll on 20/11/2020.
 */
class ShoppingApplication() : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance())
        }
    }
}