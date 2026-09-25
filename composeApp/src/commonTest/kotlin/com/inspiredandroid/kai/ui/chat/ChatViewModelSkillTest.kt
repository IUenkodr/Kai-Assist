import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.testutil.FakeDataRepository
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        advanceUntilIdle()
        assertEquals("/summarize this article please", fakeRepository.askCalls.last().first)
        assertEquals("summarize", fakeRepository.lastActiveSkillId)
        assertNull(fakeRepository.lastActiveSkillId)
        body = "body",
        description = "desc",
        displayName = id,
        fakeRepository = FakeDataRepository()
        fakeRepository.skills = listOf(skill("summarize"))
        id = id,
        return ChatViewModel(fakeRepository, noOpScheduler, unconfinedDispatcher)
        val noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        val viewModel = createViewModel()
        viewModel.state.value.actions.ask("/summarize this article please")
        viewModel.state.value.actions.ask("/unknown do something")
        viewModel.state.value.actions.ask("just a normal question")
    )
    @AfterTest
    @BeforeTest
    @Test
    fun `leading slash command routes the matching skill id and keeps text verbatim`() = runTest {
    fun `plain message passes no skill id`() = runTest {
    fun `unmatched slash command passes no skill id`() = runTest {
    fun setup() {
    fun tearDown() {
    private fun createViewModel(): ChatViewModel {
    private fun skill(id: String) = SkillManifest(
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    private val unconfinedDispatcher = UnconfinedTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class ChatViewModelSkillTest {
package com.inspiredandroid.kai.ui.chat
}
