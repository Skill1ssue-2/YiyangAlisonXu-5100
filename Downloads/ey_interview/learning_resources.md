# MCP & Vibe Coding — Learning Resources

Current as of April 2026. Ranked by signal-to-noise.

---

## MCP (Model Context Protocol)

### Primary sources — start here

1. [Model Context Protocol — official site](https://modelcontextprotocol.io) — the spec, quickstarts, concept docs. The "For Server Developers" and "For Client Developers" tutorials get you running in ~30 minutes.
2. [modelcontextprotocol GitHub org](https://github.com/modelcontextprotocol) — official org hosting the SDKs and reference servers.
3. [Reference MCP servers](https://github.com/modelcontextprotocol/servers) — ~20 production-quality example servers (filesystem, GitHub, Postgres, Slack, Google Drive, etc.). Read these as examples.
4. [Python SDK](https://github.com/modelcontextprotocol/python-sdk) — official Python SDK for building MCP servers and clients.
5. [TypeScript SDK](https://github.com/modelcontextprotocol/typescript-sdk) — official TypeScript/Node SDK.

### Anthropic's MCP docs

6. [Anthropic docs — MCP section](https://docs.anthropic.com/en/docs/agents-and-tools/mcp) — Anthropic's MCP overview and tutorials.
7. [Build an MCP server tutorial (Anthropic)](https://modelcontextprotocol.io/quickstart/server) — step-by-step server walkthrough.
8. [Claude Code — MCP integration docs](https://docs.claude.com/en/docs/claude-code/mcp) — how to register and use MCP servers inside Claude Code.
9. [Claude Desktop — MCP config](https://modelcontextprotocol.io/quickstart/user) — how to wire servers into Claude Desktop.

### Community catalogs

10. [awesome-mcp-servers (community list)](https://github.com/punkpeye/awesome-mcp-servers) — 300+ community MCP servers. Good for browsing "what's possible."
11. [MCP discussions on the Anthropic GitHub](https://github.com/modelcontextprotocol/servers/discussions) — where maintainers and contributors talk.

---

## Vibe Coding

### Primary sources

1. [Andrej Karpathy on X](https://x.com/karpathy) — he coined "vibe coding" in early 2025. Search his timeline for the original post and follow-ups.
2. [Simon Willison's blog](https://simonwillison.net) — the clearest practical writer on LLM-assisted development, extremely current. Start with his [LLMs tag](https://simonwillison.net/tags/llms/) and [AI-assisted programming tag](https://simonwillison.net/tags/ai-assisted-programming/).
3. [Ethan Mollick — One Useful Thing](https://www.oneusefulthing.org) — Wharton prof writing on how to actually get value from frontier AI tools, including coding workflows.

### Anthropic resources

4. [Anthropic docs — coding with Claude](https://docs.anthropic.com/en/docs/build-with-claude/prompt-engineering/overview) — prompt engineering, including code-focused patterns.
5. [Anthropic Cookbook](https://github.com/anthropics/anthropic-cookbook) — runnable notebooks covering tool use, agents, coding patterns.
6. [Claude Code docs](https://docs.claude.com/en/docs/claude-code/overview) — Anthropic's terminal-based coding agent; docs cover the agentic workflow in depth.
7. [Anthropic Courses (GitHub)](https://github.com/anthropics/courses) — free structured courses on prompt engineering, tool use, and real-world prompting.

### Tooling docs — read the ones you'll actually use

8. [Cursor docs](https://docs.cursor.com) — VS Code fork with deep LLM integration. Opinionated guidance on agent workflows, rules files, context management.
9. [GitHub Copilot docs](https://docs.github.com/en/copilot) — official Copilot docs covering inline, chat, and agent modes.
10. [GitHub Blog — Copilot](https://github.blog/category/ai-and-ml/) — Copilot team posts on best practices + feature updates.

### Podcasts & ongoing follow

11. [Latent Space podcast](https://www.latent.space) — interviews with builders at Cursor, Claude, Copilot, etc. Episodes on agentic coding are gold.
12. [Anthropic YouTube channel](https://www.youtube.com/@anthropic-ai) — product launches, demos, research talks.

---

## Your 2-hour study plan (pre-interview)

1. **Hour 1 — MCP hands-on.** Run the official [server quickstart](https://modelcontextprotocol.io/quickstart/server) in TypeScript. Build the weather example. Register it in Claude Desktop or Claude Code. You now have a real "yes, I've set up an MCP server" answer.
2. **30 min — read.** Skim [Karpathy's original vibe coding post](https://x.com/karpathy) (search his feed for "vibe coding") + one recent [Simon Willison post](https://simonwillison.net/tags/ai-assisted-programming/).
3. **30 min — watch.** One [Latent Space](https://www.latent.space) or [Anthropic YouTube](https://www.youtube.com/@anthropic-ai) episode on agentic coding over dinner.

## Ongoing follow (add to your RSS / bookmarks)

- [Simon Willison's blog](https://simonwillison.net) — weekly AI dev notes
- [Anthropic news](https://www.anthropic.com/news) — product and research announcements
- [modelcontextprotocol.io](https://modelcontextprotocol.io) — spec changes
- [Latent Space](https://www.latent.space) — podcast + newsletter
- [One Useful Thing](https://www.oneusefulthing.org) — Ethan Mollick's Substack

---

## Note on link freshness

AI docs move fast. If a link 404s, the content usually still exists — search the site root for the topic name. The primary orgs above (Anthropic, modelcontextprotocol, GitHub, Cursor) keep their canonical URLs stable.
