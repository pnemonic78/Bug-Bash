package pnemonic.bug_bash

import pnemonic.bug_bash.model.Scene
import kotlin.test.Test
import kotlin.test.assertEquals

class SceneTest {

    @Test
    fun next() {
        var scene = Scene.Grass
        assertEquals(Scene.Grass, scene)
        scene = scene.next()
        assertEquals(Scene.Garden, scene)
        scene = scene.next()
        assertEquals(Scene.Kitchen, scene)
        scene = scene.next()
        assertEquals(Scene.TableCloth, scene)
        scene = scene.next()
        assertEquals(Scene.TableDark, scene)
        scene = scene.next()
        assertEquals(Scene.TableRustic, scene)
        scene = scene.next()
        assertEquals(Scene.Beach, scene)
        scene = scene.next()
        assertEquals(Scene.Grass, scene)
    }
}