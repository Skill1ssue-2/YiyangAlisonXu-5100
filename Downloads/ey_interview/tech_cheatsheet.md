# EY TST Interview — Technical Cheat Sheet

Role: Transaction Strategy and Transformation — AI-driven legacy application modernization & cyber risk assessment.

Read this end-to-end twice. Then drill the **One-liner answers** section until you can say each out loud without looking.

---

## 1. Frontier LLMs (Claude Sonnet/Opus, ChatGPT)

### What "Frontier LLM" means
The most capable current-generation large language models. They can reason, write code, analyze documents, and use tools. "Frontier" = the leading edge of what's possible today.

### The three you must know
| Model | Vendor | When to use |
|---|---|---|
| **Claude Sonnet** | Anthropic | Daily driver — fast, strong at coding, long context (200K+ tokens), great for reviewing legacy codebases |
| **Claude Opus** | Anthropic | Hardest problems — deep reasoning, architecture design, complex security analysis, strategic synthesis |
| **ChatGPT (GPT-4/5)** | OpenAI | Broadest ecosystem, strong general-purpose, plugins + image + voice |

### Key concepts
- **Context window**: How much text the model can "see" at once. Claude's 200K tokens ≈ 150K words ≈ a full legacy codebase module.
- **Token**: Roughly ¾ of a word. You pay per token for API use.
- **System prompt**: Instructions that shape the model's behavior for the whole session ("You are a security analyst. Flag vulnerabilities in OWASP Top 10 categories…").
- **Temperature**: 0 = deterministic/factual, 1 = creative. Security code review → low temp. Brainstorming → high.
- **Hallucination**: Model confidently states something false. Mitigations: grounding with sources, RAG, tool use, human review.
- **RAG (Retrieval-Augmented Generation)**: Before answering, fetch relevant documents from a vector DB and feed them in as context. Reduces hallucination; grounds answers in your data.
- **Fine-tuning vs. prompting**: Fine-tuning changes model weights on your data (expensive, slow). Prompting / RAG is the default — faster, cheaper, easier to iterate.

### One-liner: "What's the difference between Sonnet and Opus?"
*"Same model family from Anthropic. Sonnet is the balanced workhorse — fast and cheap enough for day-to-day coding and review. Opus is the heavy-reasoning tier — slower and pricier, but you reach for it on architecture design, security audits, or strategy synthesis where you want the model's strongest judgment."*

---

## 2. GitHub & GitHub Copilot

### GitHub
- Git hosting platform owned by Microsoft. The de facto standard for source control, PR review, CI/CD (GitHub Actions), and now AI-assisted development.
- **Core workflow**: clone → branch → commit → push → pull request → review → merge.
- **Why it matters for consulting**: clients hand you a repo; you clone, analyze, propose changes through PRs so there's an auditable trail.

### GitHub Copilot
- AI pair programmer that lives inside your editor (VS Code, JetBrains, etc.).
- **Three main modes**:
  1. **Inline completion**: Ghost-text suggestions as you type. Tab to accept.
  2. **Chat**: Sidebar conversation — "explain this function", "write a unit test for this class", "find the bug."
  3. **Copilot Agent / Workspace**: Multi-file task execution — "refactor this module to use async/await across all call sites."
- **Under the hood**: Originally built on OpenAI Codex/GPT; now supports multiple models (GPT-4/5, Claude, Gemini) — you pick.
- **Key use cases for this role**:
  - Generate unit tests against legacy functions to establish a safety net before refactoring.
  - Explain legacy code written in unfamiliar languages (COBOL, VB6, old PHP).
  - Scaffold new JavaScript/Java services that replace legacy components.
  - Auto-complete boilerplate so you focus on business logic.

### One-liner: "How do you use Copilot responsibly in enterprise code?"
*"Three guardrails: (1) never accept a suggestion you can't explain, (2) run it through the normal PR review and tests like any other code, (3) be deliberate about what context you feed it — for regulated clients you want enterprise Copilot with data-residency guarantees, not the consumer tier."*

---

## 3. VS Code (Visual Studio Code)

- Free, extensible code editor from Microsoft. The default editor for modern dev and the hub where most AI dev tooling plugs in (Copilot, Claude Code, Cursor, MCP clients).
- **Why it's JD-mentioned**: It's the standard surface where Copilot + MCP servers + terminal + Git all integrate.
- **Key extensions**: GitHub Copilot, GitLens, REST Client, language-specific (Java, ESLint), Remote-SSH/Dev Containers.
- **Dev Containers**: Spin up a consistent dev environment per project defined in a `devcontainer.json`. Useful for legacy modernization engagements where each client has weird toolchain requirements.

---

## 4. MCP (Model Context Protocol) — CRITICAL, learn this deeply

### What it is
An **open standard** introduced by Anthropic in late 2024 that lets LLMs connect to external tools, data sources, and systems through a uniform interface. It's the "USB-C for AI" — any MCP-compatible client (Claude Desktop, VS Code, Cursor) can plug into any MCP server (GitHub, Jira, your database, a file system, a custom tool).

### Why it matters
Before MCP, every AI tool integration was bespoke. MCP standardizes it, so enterprise clients can safely let LLMs read their Jira, query their databases, modify files, post to Slack — with auditable, scoped access.

### The architecture
```
┌──────────────┐   MCP    ┌──────────────┐
│  MCP Client  │ ───────► │  MCP Server  │
│ (Claude,     │          │ (GitHub,     │
│  VS Code,    │          │  Jira, DB,   │
│  Cursor…)    │          │  custom…)    │
└──────────────┘          └──────────────┘
```
- **Client**: The LLM-facing app (Claude Desktop, Copilot, Cursor, custom agent).
- **Server**: A small program that exposes **tools** (functions the LLM can call), **resources** (data it can read), and **prompts** (reusable templates). Written in Python or TypeScript typically.
- **Transport**: stdio (local) or HTTP/SSE (remote).

### Common MCP servers you'd set up for a modernization engagement
- **Filesystem MCP** → read legacy source code
- **GitHub MCP** → create branches, open PRs, read issues
- **Jira/Confluence MCP** → pull requirements, write status
- **Database MCP** (Postgres/MSSQL) → inspect legacy schemas
- **Custom MCP** → wrap a client's proprietary API or static-analysis tool so the LLM can drive it

### The "MCP server setup" workflow (what the JD literally asks about)
1. Pick or write an MCP server (lots of prebuilt ones on GitHub).
2. Install it (`npm install` / `pip install` / `uvx`).
3. Register it in the client's config file — for Claude Desktop it's `claude_desktop_config.json`, for VS Code it's in the settings/MCP config.
4. Restart the client; verify the tools show up.
5. In a prompt, the LLM calls the tool when needed; the server executes; result feeds back into the context.

### One-liner: "Explain MCP to a non-technical client"
*"MCP is like giving the AI model a set of hands. On its own, an LLM can only read and write text. MCP is a standard way to let it securely reach into your systems — your code repo, your Jira, your database — so it can actually do work, not just talk about it. The standard matters because without it every integration is custom and ungovernable."*

---

## 5. "Vibe Coding" with Frontier LLMs

### What it is
A development style where you **describe the outcome in natural language** and let the LLM generate and iterate the code while you steer with intent, taste, and tests — rather than writing every line yourself. Term popularized by Andrej Karpathy in early 2025.

### What it is NOT
- Not "no-review autogeneration" — you still read, test, and own the output.
- Not replacement for knowing how to code — you have to recognize bad code to steer away from it.

### Typical vibe-coding loop (JavaScript/Java example)
1. **Describe intent**: "Build a REST endpoint in Express that accepts a legacy-format CSV upload, validates rows, writes to Postgres, returns a job ID."
2. **Review the scaffold** the LLM generates.
3. **Run it** — it breaks. Paste the error back.
4. **Iterate** — "The validation is missing handling for empty columns; also switch to streaming for files >10MB."
5. **Tighten with tests** — "Write Jest tests covering these edge cases: [list]."
6. **Commit and PR**.

### Tools that support this well
- Claude Code (Anthropic CLI) — runs in your terminal, edits files, runs tests
- Cursor — VS Code fork with deep LLM integration
- GitHub Copilot Workspace / Agent — multi-file tasks inside GitHub
- Windsurf (Codeium) — similar to Cursor

### Why EY cares
For legacy modernization, you're often rewriting code in a language the client's team doesn't own well. Vibe coding lets a small team (2–3 people, per JD) deliver output that used to need a much bigger dev crew. That's the value prop.

### One-liner: "How do you keep vibe-coded output production-grade?"
*"Three things: tests first — I ask the LLM to write tests against the current behavior before touching the legacy code, so the refactor can't silently break it. Small PRs — every change is reviewed and revertable. And explicit architecture boundaries — I don't let the model invent new patterns, I give it the existing patterns to match."*

---

## 6. Agentic AI

### What it is
LLMs that **plan multi-step tasks, call tools (often via MCP), loop, and adapt** until a goal is reached — rather than answering a single prompt. An agent takes a goal like "audit this repo for SQL injection risks" and decomposes it: list files → read each → analyze → aggregate → report.

### Core agent loop
```
   Goal → Plan → Act (call tool) → Observe result → Reflect → Re-plan → …
```

### Key terms
- **Tool use / function calling**: The model outputs structured JSON saying "call `read_file` with path=X" — the harness executes, returns result.
- **ReAct pattern**: Reason → Act → Observe, looped. Foundational agent pattern.
- **Multi-agent**: Planner agent + specialist agents (e.g., a security-review agent spawning a code-analyzer agent).
- **Human-in-the-loop**: Agent pauses for approval before risky actions.

### Why it's the future of modernization work
A single agent can: clone a legacy repo → read the code → map dependencies → identify vulnerabilities → propose a refactor plan → open PRs with the changes — in hours, not weeks. Humans supervise and make judgment calls.

### One-liner: "What's agentic AI, simply?"
*"A regular LLM is a smart assistant that answers one question. An agentic AI is the same brain, but it plans a multi-step task, uses tools to act in the world, observes the results, and keeps going until the goal is done. The shift is from 'assistant' to 'autonomous worker with oversight.'"*

---

## 7. AI-Driven Legacy Application Modernization — Full Workflow

This is the core EY TST deliverable. Memorize the phases.

### Phase 1: Discovery & Assessment
- Ingest the legacy codebase (often COBOL, VB6, old Java, .NET Framework, mainframe) into LLM-accessible form — usually via a file-system MCP server or a vector database for retrieval.
- LLM maps: entry points, business logic modules, data flows, third-party dependencies, dead code.
- Output: **Current-state architecture map + dependency graph**.

### Phase 2: Cyber Risk Identification
- LLM scans for OWASP Top 10 and CWE patterns (see §8).
- Cross-references dependencies against CVE databases.
- Flags cryptographic weaknesses, hardcoded secrets, privilege escalation paths.
- Output: **Risk register with severity + exploitability + remediation path per finding**.

### Phase 3: Modernization Target Design
- Propose target architecture (monolith → microservices, on-prem → cloud-native, old JS frameworks → React/Next.js, Java 6 → Java 21 / Spring Boot).
- Value case: cost-to-serve, time-to-market, risk reduction, compliance posture.
- Output: **Future-state architecture + phased roadmap + business case**.

### Phase 4: Execution (AI-Accelerated)
- Test-harness first: LLM generates characterization tests against current behavior.
- Strangler-fig pattern: new service routes traffic away from legacy incrementally.
- Copilot/Claude-assisted code generation under human review.
- CI/CD automation, SAST/DAST in pipeline.

### Phase 5: Value Realization
- Define KPIs pre-engagement (throughput, MTTR, license cost, incident rate, dev velocity).
- Track post-migration; report variance.
- Tie back to the business case from Phase 3.

### Common patterns to namedrop
- **Strangler Fig pattern**: Gradually replace legacy by routing traffic away from it — never a big-bang rewrite.
- **Anti-Corruption Layer**: Adapter between new code and legacy to prevent legacy concepts leaking in.
- **Characterization tests**: Tests that capture *current* behavior (even if buggy) so you can refactor safely.
- **Branch-by-abstraction**: Refactor through an abstraction layer so old and new code can coexist during migration.

---

## 8. Cyber Risk & AI-Driven Security Review

### The OWASP Top 10 (2021, still current reference) — memorize the categories
1. **Broken Access Control** — users doing things they shouldn't be allowed to
2. **Cryptographic Failures** — weak or missing encryption, hardcoded keys
3. **Injection** — SQL injection, command injection, LDAP injection, XSS
4. **Insecure Design** — architectural flaws (missing rate limits, no threat model)
5. **Security Misconfiguration** — default creds, verbose errors, unnecessary features on
6. **Vulnerable & Outdated Components** — unpatched libraries (classic: Log4Shell / log4j CVE-2021-44228)
7. **Identification & Authentication Failures** — weak passwords, broken session mgmt
8. **Software & Data Integrity Failures** — unsigned updates, insecure deserialization
9. **Security Logging & Monitoring Failures** — no audit trail, no alerting
10. **Server-Side Request Forgery (SSRF)** — server fetches attacker-controlled URLs

### Typical vulnerabilities in legacy apps (what AI is great at surfacing)
- **SQL injection**: String concatenation in queries (`"SELECT * FROM users WHERE id=" + userId`).
- **Hardcoded credentials**: API keys, DB passwords in source or config files.
- **Outdated crypto**: MD5, SHA-1 for passwords; DES/3DES; static IVs.
- **Unpatched dependencies**: Old log4j, old struts, old jQuery, old OpenSSL.
- **Missing input validation**: Trusting client-side checks.
- **Deserialization vulnerabilities**: `ObjectInputStream.readObject()` on untrusted data (Java), `pickle.load` (Python), `unserialize` (PHP).
- **Session fixation / weak tokens**: Predictable session IDs, no rotation on login.
- **XXE (XML External Entities)**: Old XML parsers processing external entities by default.
- **Path traversal**: `../../../etc/passwd` via unsanitized file paths.

### How an LLM actually finds these
- Pattern recognition across files (can hold 200K tokens of code in Claude).
- Cross-file taint analysis: trace user input from entry point through to dangerous sinks.
- Dependency CVE lookup via MCP tool.
- Explains the vulnerability in plain language for the client.
- **Limitation**: Can hallucinate findings. Always verify with SAST (Semgrep, SonarQube, CodeQL) and DAST (OWASP ZAP, Burp).

### Where to position AI vs. traditional tooling
Don't claim AI replaces SAST/DAST. Position it as:
- **Faster triage** of SAST findings (filters false positives, explains impact)
- **Cross-language context** (a single LLM can reason about a Python service calling a Java service calling a COBOL job)
- **Remediation code generation** (given a finding, propose the fix)
- **Threat modeling assistance** in design review

### One-liner: "How do you use AI for legacy security assessment without hallucinating findings?"
*"The LLM is the triage and explanation layer, not the source of truth. I run traditional SAST tools first, then use the LLM to cluster findings, filter noise, explain exploitability in business terms, and draft remediation code. For anything novel, the LLM flags a suspicion and I verify manually or with a targeted DAST probe before it hits the report."*

---

## 9. Consulting Concepts (EY-Specific Vocabulary)

### Value Realization
Framework for ensuring a client actually captures the benefits a project promised. Steps:
1. Baseline current-state KPIs (cost, cycle time, incident rate, revenue per unit).
2. Set target KPIs tied to the business case.
3. Track post-implementation against targets.
4. Attribute delta to the initiative (controls for confounders).
5. Report to exec sponsor; adjust if targets are drifting.

### Value Case / Business Case
Quantified answer to "why are we doing this": cost to deliver, expected benefit (cost saved, revenue enabled, risk reduced), timeline, NPV/IRR if relevant.

### Strategy → Transformation → Run (EY TST frame)
- **Strategy**: What should we do and why?
- **Transformation**: How do we get from here to there? (where this role lives)
- **Run**: Operate the new state.

### Other phrases that sound native at EY
- "Target operating model (TOM)"
- "Current state / future state / transition state"
- "Capability heatmap"
- "Value drivers"
- "Executable roadmap"
- "Workstream"
- "RACI"
- "Steering committee / steerco"
- "Minimum viable product (MVP) / minimum lovable product (MLP)"

---

## 10. Cloud & Platform Context (nice to have, brief)

- **AWS / Azure / GCP**: Big 3 clouds. You have AWS Solutions Architect – Associate — lean on that.
- **Containerization**: Docker (containers) + Kubernetes (orchestration). Legacy → microservices usually lands here.
- **Serverless**: Lambda / Azure Functions — pay per execution, auto-scaling, good for event-driven modernization.
- **CI/CD**: GitHub Actions, Azure DevOps, Jenkins. Modern pipelines include SAST, DAST, dependency scanning (Snyk, Dependabot).
- **Infrastructure as Code (IaC)**: Terraform, CloudFormation, Bicep — version-controlled infra.

---

## 11. Federal Government Context (NAV CANADA + clearance angle)

- You're eligible for federal security clearance — EY's federal practice is significant.
- Canadian federal clearance levels (memorize): **Reliability Status** → **Secret** → **Top Secret**. Most consulting engagements need Secret.
- NAV CANADA is a private, not-for-profit corporation but operates the civil air navigation system — it's treated as critical infrastructure with federal-style rigor.
- Key federal IT themes you'd discuss: data residency (Canadian-hosted), PIPEDA / Privacy Act, Protected A/B/C data classification, ITSG-33 security controls.

---

## 12. Weak-Point Coverage Scripts (memorize cold)

**If asked "what JavaScript or Java app have you actually built with vibe coding?"**
*"I've been hands-on over the last several months building small services to internalize the vibe-coding loop — an MCP server that exposes a document repository, a Node/Express service for CSV ingestion with validation, and a Java Spring Boot API wrapper. The point wasn't scale, it was to get fluent in the feedback loop: test-first prompting, small commits, model-steering. I'm ready to bring that into a client engagement on day one and scale it with the team."*

*(Before the interview, make sure you can truthfully say at least one concrete example. If you haven't built one yet, build a small MCP server tonight using the TypeScript SDK quickstart — it's genuinely a few hours of work.)*

**If asked "what's your direct cybersecurity experience?"**
*"My security experience is adjacent rather than as a dedicated AppSec engineer. At Ford I owned non-functional requirements including security posture and incident response for connected vehicle services, and I'm comfortable with the OWASP Top 10 and how AI tooling surfaces those patterns in legacy code. What I bring to this role is the assessment and strategy layer — translating security findings into client risk registers and remediation roadmaps — combined with a strong willingness to deepen the hands-on side fast."*

**If asked "have you done application development work?"**
*"Yes, but I want to be precise. My development work has been analytical and integration-oriented — Python for data analysis at Ford, SQL + Power BI stack builds at Plug and Play and Mobis, Power Platform custom apps at NAV CANADA. The newer frontier I've been deliberately pushing into is AI-assisted JavaScript and Java development using Copilot, Claude, and MCP — which is exactly what this JD calls out."*

---

## 13. 60-Second Opening Pitch (rehearse until smooth)

*"I'm a technology strategy professional with seven-plus years across Ford, Plug and Play, Hyundai Mobis, and most recently NAV CANADA, where I worked inside a federal air navigation service provider delivering AI and legacy modernization research to senior leadership. I just finished my MSIS at Northeastern with a 4.0 GPA, and over the last year I've gone deep on Frontier LLMs — Claude Sonnet and Opus, Copilot, MCP server setups — using them on legacy system assessments and modernization roadmaps. What draws me to EY TST is that it sits at the exact intersection I've been moving toward: consulting, AI, and measurable client value. And I'm eligible for federal clearance, which I know matters for part of your book."*

---

## 14. Quick-reference glossary (drill these)

| Term | Meaning |
|---|---|
| LLM | Large Language Model |
| MCP | Model Context Protocol — standard for connecting LLMs to tools/data |
| RAG | Retrieval-Augmented Generation — fetch relevant docs, feed as context |
| SAST | Static Application Security Testing — scans source code |
| DAST | Dynamic Application Security Testing — attacks running app |
| CVE | Common Vulnerabilities and Exposures — public vuln database |
| CWE | Common Weakness Enumeration — vulnerability categories |
| OWASP | Open Web Application Security Project |
| TOM | Target Operating Model |
| NFR | Non-Functional Requirement (performance, security, SLA) |
| IaC | Infrastructure as Code |
| SAST | Static Analysis |
| SLA | Service Level Agreement |
| PoC | Proof of Concept |
| RACI | Responsible, Accountable, Consulted, Informed |
| MVP | Minimum Viable Product |
| SDLC | Software Development Lifecycle |
