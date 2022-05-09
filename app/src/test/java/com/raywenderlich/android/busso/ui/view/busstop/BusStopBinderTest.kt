package com.raywenderlich.android.busso.ui.view.busstop

//@RunWith(RobolectricTestRunner::class)
//@Config(sdk = [Build.VERSION_CODES.P])
//class BusStopListViewBinderImplTest {
//    private lateinit var busStopListViewBinder:
//            BusStopListViewBinder
//    private lateinit var fakeBusStopItemSelectedListener:
//            FakeBusStopItemSelectedListener
//    private lateinit var activityController:
//            ActivityController<Activity>
//    private lateinit var testData: List<BusStopViewModel>
//
//    @Before
//    fun setUp() {
//        activityController = Robolectric.buildActivity(
//            Activity::class.java
//        )
//        testData = createTestData()
//        fakeBusStopItemSelectedListener =
//            FakeBusStopItemSelectedListener()
//        busStopListViewBinder =
//            BusStopListViewBinderImpl(fakeBusStopItemSelectedListener)
//    }
//
//    // 1
//    fun displayBusStopList_whenInvoked_adapterContainsData() {
//        val rootView = createLayoutForTest(activityController.get())
//        with(busStopListViewBinder) {
//            init(rootView)
//            displayBusStopList(testData)
//        }
//        val adapter =
//            rootView.findViewById<RecyclerView>(R.id.busstop_recyclerview).adapter!!
//        assertEquals(3, adapter.itemCount)
//    }
//
//    // 2
//    @Test
//    fun busStopItemSelectedListener_whenBusStopSelected_onBusStopSelectedIsInvoked() {
//        val testData = createTestData()
//        val activity = activityController.get()
//        val rootView = createLayoutForTest(activity)
//        activity.setContentView(rootView)
//        activityController.create().start().visible()
//        with(busStopListViewBinder) {
//            init(rootView)
//            displayBusStopList(testData)
//        }
//
//        rootView.findViewById<RecyclerView>(R.id.busstop_recyclerview).getChildAt(2).performClick()
//        assertEquals(
//            testData[2],
//            fakeBusStopItemSelectedListener.onBusStopSelectedInvokedWith
//        )
//    }
//
//    private class FakeBusStopItemSelectedListener :
//        BusStopListViewBinder.BusStopItemSelectedListener {
//        var onBusStopSelectedInvokedWith: BusStopViewModel? = null
//        var retryInvoked = false
//        override fun onBusStopSelected(
//            busStopViewModel:
//            BusStopViewModel
//        ) {
//            onBusStopSelectedInvokedWith = busStopViewModel
//        }
//
//        override fun retry() {
//            retryInvoked = true
//        }
//    }
//
//    private fun createTestData() = listOf(
//        createBusStopViewModelForTest("1"),
//        createBusStopViewModelForTest("2"),
//    createBusStopViewModelForTest("3"),
//    )
//    private fun createBusStopViewModelForTest(id: String) =
//        BusStopViewModel(
//            "stopId $id",
//            "stopName $id",
//            "stopDirection $id",
//            "stopIndicator $id",
//            "stopDistance $id"
//        )
//
//    private fun createLayoutForTest(context: Context) =
//        LinearLayout(context)
//            .apply {
//                addView(RecyclerView(context).apply {
//                    id = R.id.busstop_recyclerview
//                })
//            }
//}